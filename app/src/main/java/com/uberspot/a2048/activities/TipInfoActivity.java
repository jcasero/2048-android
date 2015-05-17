
package com.uberspot.a2048.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.uberspot.a2048.R;
import com.uberspot.a2048.utils.Constants;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TipInfoActivity extends AppCompatActivity {
    @InjectView(R.id.tip_info_title)        TextView mTitle;
    @InjectView(R.id.tip_info_subtitle)     TextView mSubTitle;
    @InjectView(R.id.tip_info_main_toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_info_main);
        ButterKnife.inject(this);

        if(getIntent() != null) {
            int title = getIntent().getIntExtra(Constants.EXTRA_TIP_TITLE_ID, R.string.app_name);
            int subtitle = getIntent().getIntExtra(Constants.EXTRA_TIP_SUBTITLE_ID, R.string.app_name);

            mTitle.setText(title);
            mSubTitle.setText(subtitle);
        }

        mToolbar.setTitle(R.string.tip_and_trick);

        setSupportActionBar(mToolbar);

        if(getSupportActionBar() == null) return;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
