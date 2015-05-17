
package com.uberspot.a2048;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.uberspot.a2048.interfaces.OnChangeHomeIcon;
import com.uberspot.a2048.interfaces.OnMenuItemSelected;
import com.uberspot.a2048.managers.MenuManager;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements OnMenuItemSelected, OnChangeHomeIcon {
    @InjectView(R.id.activity_main_drawer)      protected DrawerLayout mDrawerLayout;
    @InjectView(R.id.activity_main_toolbar)     protected Toolbar mToolbar;

    private ActionBarDrawerToggle mDrawerToggle;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mFragmentManager = getSupportFragmentManager();

        setUpToolbar();
        select(MenuManager.MenuType.GAMES);
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
        MenuManager menuManager = new MenuManager();
        Fragment fragment = menuManager.getItemFragment(type);

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
