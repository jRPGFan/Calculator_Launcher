package com.example.CalculatorLauncherApp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button launchCalculator = findViewById(R.id.launchCalculatorButton);
        launchCalculator.setOnClickListener(v -> {
            //List<PackageInfo> pi = getPackageManager().getInstalledPackages(PackageManager.GET_META_DATA);
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.Calculator");
            if (launchIntent != null) {
                startActivity(launchIntent);
                finish();
            } else {
                Toast.makeText(MainActivity.this, "There is no such application available on this phone",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}