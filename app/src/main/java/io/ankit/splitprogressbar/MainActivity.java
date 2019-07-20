package io.ankit.splitprogressbar;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import io.ankit.splitprogress.SplitProgressDialog;

public class MainActivity extends AppCompatActivity {
    Button show;
    int i = 0;
    SplitProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = findViewById(R.id.show);
        progressDialog = new SplitProgressDialog(MainActivity.this);


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(true);
                progressDialog.setTitle(R.string.app_name);
                progressDialog.resizeDialog(500, 500);
                //progressDialog.getWindow().setLayout(500, 500);
                Drawable drawable = new ColorDrawable(Color.BLACK);
                progressDialog.setBackgroundColor(drawable);
                progressDialog.show();

                final Timer t = new Timer();
                t.scheduleAtFixedRate(new TimerTask() {

                                          @Override
                                          public void run() {
                                              i++;
                                              runOnUiThread(new Runnable() {

                                                  @Override
                                                  public void run() {
                                                      progressDialog.setProgress(i);

                                                      if (i == 100) {
                                                          i = 0;
                                                          progressDialog.dismiss();
                                                          t.cancel();
                                                          Toast.makeText(MainActivity.this, "Loading Finished.....", Toast.LENGTH_SHORT).show();
                                                      }

                                                  }
                                              });
                                          }

                                      },
                        0,
                        100);
            }
        });
    }
}
