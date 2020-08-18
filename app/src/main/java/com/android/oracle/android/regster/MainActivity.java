package com.android.oracle.android.regster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    private TextView text, errorText;
    private Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("View");

        text = (TextView) findViewById(R.id.textView);
        errorText = (TextView) findViewById(R.id.textView2);
        show = (Button) findViewById(R.id.button);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Async().execute();

            }

        });

    }


    class Async extends AsyncTask<Void, Void, Void> {
        String records = "", error = "";
        private Connection connection;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");

                Connection con = DriverManager.getConnection(
                        "jdbc:oracle:thin:@192.168.1.100:1521:xe", "hr", "hr");


                Statement statement = con.createStatement();

                ResultSet resultSet = statement.executeQuery(" select * from noida");

                while (resultSet.next()) {

                    records += resultSet.getString(1) + " " + resultSet.getString(2) + "\n";

                }

            } catch (Exception e) {
                System.out.println("India" + e);

                error = e.toString();

            }

            return null;

        }


        @Override

        protected void onPostExecute(Void aVoid) {

            text.setText(records);

            if (error != "")

                errorText.setText(error);

            super.onPostExecute(aVoid);

        }


    }
}