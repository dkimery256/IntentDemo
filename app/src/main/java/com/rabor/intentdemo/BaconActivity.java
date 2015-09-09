package com.rabor.intentdemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class BaconActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);

        Intent i = new Intent(this, MyService.class);
        startService(i);
    }

    public void baconClick(View view) {
        final EditText baconEditText = (EditText) findViewById(R.id.baconEditText);

        Intent i = new Intent(this, AppleActivity.class);

        String msg = baconEditText.getText().toString();
        i.putExtra("msg", msg);

        startActivity(i);
    }

}
