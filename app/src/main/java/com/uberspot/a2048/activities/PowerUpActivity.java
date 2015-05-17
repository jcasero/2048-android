
package com.uberspot.a2048.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.uberspot.a2048.MainActivity;
import com.uberspot.a2048.R;
import com.uberspot.a2048.utils.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PowerUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.power_up_main);
        ButterKnife.inject(this);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int powerUp = preferences.getInt(Constants.PREFERENCE_POWER_UP, 0);
        powerUp++;
        preferences.edit().putInt(Constants.PREFERENCE_POWER_UP, powerUp).apply();

        if(getSupportActionBar() == null) return;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @OnClick(R.id.power_up_start)
    protected void onClickStart(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
