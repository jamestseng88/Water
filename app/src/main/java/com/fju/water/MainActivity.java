package com.fju.water;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    float degree;
    float fee = 0;

    private EditText edMonth;
    private EditText edNext;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edMonth = findViewById(R.id.month);
        edNext = findViewById(R.id.next);
        button = findViewById(R.id.calculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Spinner cities = findViewById(R.id.spinner);
        cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,getResources().getStringArray(R.array.cities)[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
public void calc (  ){
        String monthString = edMonth.getText().toString();
        String nextString = edNext.getText().toString();
        if(!TextUtils.isEmpty(monthString)) {
            degree = Float.parseFloat(monthString);
            if (degree >= 1 && degree <= 10) {
                fee = degree * 7.35f;
            } else if (degree >= 11 && degree <= 30) {
                fee = degree * 9.45f - 21;
            } else if (degree >= 31 && degree <= 50) {
                fee = degree * 11.55f - 84;
            } else if (degree > 51) {
                fee = degree * 12.075f - 110.25f;
            }
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra(getString(R.string.extra_fee),fee);
            startActivity(intent);
        }else {
            if (!TextUtils.isEmpty(nextString)) {
                degree = Float.parseFloat(nextString);
                if (degree >= 1 && degree <= 20) {
                    fee = degree * 7.35f;
                } else if (degree >= 21 && degree <= 60) {
                    fee = degree * 9.45f - 21;
                } else if (degree >= 61 && degree <= 100) {
                    fee = degree * 11.55f - 84;
                } else if (degree > 100) {
                    fee = degree * 12.075f - 220.25f;
                }
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("FEE",fee);
                startActivity(intent);
            }
        }


}


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
