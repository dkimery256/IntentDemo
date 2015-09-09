package com.rabor.intentdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;


public class AppleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);

        Intent i = new Intent(this, MyIntentService.class);
        startService(i);

        Bundle appleData = getIntent().getExtras();
        if(appleData == null) {
            return;
        }

        String msg = appleData.getString("msg");
        final TextView applesTextView = (TextView) findViewById(R.id.applesTextView);
        applesTextView.setText(msg);
    }

    public void appleClick(View view) {
        Intent i = new Intent(this, BaconActivity.class);
        startActivity(i);
    }
}
