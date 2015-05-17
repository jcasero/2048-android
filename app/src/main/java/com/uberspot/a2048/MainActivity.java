
package com.uberspot.a2048;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.uberspot.a2048.activities.TipInfoActivity;
import com.uberspot.a2048.adapters.models.GamesAdapterItem;
import com.uberspot.a2048.adapters.models.TipAdapterItem;
import com.uberspot.a2048.fragments.content.GameFragment;
import com.uberspot.a2048.interfaces.OnChangeHomeIcon;
import com.uberspot.a2048.interfaces.OnMenuItemSelected;
import com.uberspot.a2048.managers.MenuManager;
import com.uberspot.a2048.model.DeepLinkModel;
import com.uberspot.a2048.utils.Constants;
import com.uberspot.a2048.utils.ResourcesUtils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements OnMenuItemSelected, OnChangeHomeIcon {
    @InjectView(R.id.activity_main_drawer)      protected DrawerLayout mDrawerLayout;
    @InjectView(R.id.activity_main_toolbar)     protected Toolbar mToolbar;

    private ActionBarDrawerToggle mDrawerToggle;
    private FragmentManager mFragmentManager;
    private MenuManager mMenuManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mFragmentManager = getSupportFragmentManager();
        mMenuManager = new MenuManager();
        setUpToolbar();

        Intent intent = getIntent();
        Uri data = intent.getData();

        DeepLinkModel model = mMenuManager.getInitialItem(data);
        setFirstScreen(model);
    }

    private void setFirstScreen(DeepLinkModel model) {
        if(model.getType() == MenuManager.MenuType.GAMES && model.getItem() != null && !model.getItem().equals("")) {
            selectGame(model);
        } else if(model.getType() == MenuManager.MenuType.TIPS && model.getItem() != null && !model.getItem().equals("")) {
            selectTip(model);
        } else {
            select(model.getType());
        }
    }

    private void selectTip(DeepLinkModel model) {
        List<TipAdapterItem> items = ResourcesUtils.getTips();

        int tip = Integer.MAX_VALUE;

        try {
            tip = Integer.valueOf(model.getItem());
        } catch (NumberFormatException e) {
            Log.e(Constants.TAG, e.toString());
        }

        if(tip < items.size()) {
            TipAdapterItem item = items.get(tip);
            Intent intent = new Intent(this, TipInfoActivity.class);
            intent.putExtra(Constants.EXTRA_TIP_TITLE_ID, item.getTitle());
            intent.putExtra(Constants.EXTRA_TIP_SUBTITLE_ID, item.getBody());
            startActivity(intent);
            finish();
        } else {
            select(model.getType());
        }
    }

    private void selectGame(DeepLinkModel model) {
        List<GamesAdapterItem> items = ResourcesUtils.getGamesVariants();
        int variant = Integer.MAX_VALUE;

        try {
            variant = Integer.valueOf(model.getItem());
        } catch (NumberFormatException e) {
            Log.e(Constants.TAG, e.toString());
        }

        if(variant < items.size()) {
            GamesAdapterItem item = items.get(variant);
            GameFragment fragment = GameFragment.getInstance(item.getTitle(), item.getPath());
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_main_content, fragment);
            transaction.commit();
        } else {
            select(model.getType());
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void setUpToolbar() {
        setSupportActionBar(mToolbar);

        mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.primary_dark));
        mToolbar.setBackgroundResource(R.color.primary);

        mDrawerToggle = new ActionBarDrawerToggle(this,  mDrawerLayout, mToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close );

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if(getSupportActionBar() == null) return; //This should never happen but we need control it.

        mDrawerToggle.syncState();

        mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override public void onMenuItemSelected(int item) {
        MenuManager.MenuType type = MenuManager.MenuType.values()[item];
        select(type);
        mDrawerLayout.closeDrawers();
    }

    @Override public void onChangeHomeIcon(boolean state) {
        mDrawerToggle.setDrawerIndicatorEnabled(state);
    }

    private void select(MenuManager.MenuType type) {

        Fragment fragment = mMenuManager.getItemFragment(type);

        if(fragment == null) return;

        mFragmentManager.beginTransaction().replace(R.id.activity_main_content, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if(mFragmentManager.getBackStackEntryCount() > 0) {
            mFragmentManager.popBackStack();
            this.onChangeHomeIcon(true);
        } else {
            super.onBackPressed();
        }
    }


}
