package sg.edu.rp.c346.id19020125.demoexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int requestCodeForSupermanStats = 1;
    int requestCodeForBatmanStats = 2;

    TextView tvSuperman, tvBatman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSuperman = findViewById(R.id.textViewSuperman);
        tvBatman = findViewById(R.id.textViewBatman);

        //Set listener to handle the clicking of superman text view
        tvSuperman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Hero object
                Hero superman = new Hero("Superman", 100, 60);
                Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);
                //Put the Hero object into the intent
                i.putExtra("hero", superman);
//                startActivity(i);
                startActivityForResult(i, requestCodeForSupermanStats);
            }
        });

        //Set listener to handle the clicking of batman text view
        tvBatman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Hero object
                Hero batman = new Hero("Batman", 60, 90);
                Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);
                //Put the Hero object into the intent
                i.putExtra("hero", batman);
//                startActivity(i);
                startActivityForResult(i, requestCodeForBatmanStats);
            }
        });
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(resultCode == RESULT_OK){
                if (data != null) {
                    String like = data.getStringExtra("like");
                    String statement = "";
                    if(requestCode == requestCodeForSupermanStats){
                        statement = "You " + like + " Superman";
                    }
                    if(requestCode == requestCodeForBatmanStats){
                        statement = "You " + like + " Batman";
                    }

                    Toast.makeText(MainActivity.this, statement,
                            Toast.LENGTH_LONG).show();
                }
            }
        }

    }