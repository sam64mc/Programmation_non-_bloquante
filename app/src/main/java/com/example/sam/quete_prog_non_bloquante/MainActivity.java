package com.example.sam.quete_prog_non_bloquante;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private boolean isLiftMoving = false;
    private int currentFloor = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(0);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(8);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(9);
            }
        });


    }

    private void goToFloor(int floor) {
        if (!isLiftMoving && floor != currentFloor) {
            moveNextFloor(floor);
            isLiftMoving = false;
        }
    }

    private void moveNextFloor(int floor) {
        if (floor != currentFloor) {
            new MoveLift().execute(floor);
        }

    }

    private class MoveLift extends AsyncTask<Integer,Void, Integer>{


        @Override
        protected Integer doInBackground(Integer...integers) {
            Integer floor = integers[0];
            SystemClock.sleep(3000);
            return floor;
        }


        @Override
        protected void onPostExecute(Integer floor) {
            isLiftMoving = true;
            currentFloor= (floor > currentFloor) ? currentFloor + 1 : currentFloor - 1;
            TextView floorCount = (TextView) findViewById(R.id.floor_count);
            floorCount.setText(String.valueOf(currentFloor));
            moveNextFloor(floor);
            isLiftMoving = false;
        }

    }
}



