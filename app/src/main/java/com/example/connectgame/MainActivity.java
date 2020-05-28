package com.example.connectgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.*;

import java.time.format.TextStyle;

public class MainActivity extends AppCompatActivity {
    // 0 for yellow and 1 for red 2 for empty
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winpos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int activeplayer = 0;
    boolean gameactive=true;
    public void dropin(View view) {
        ImageView counter = (ImageView) view;

        int tapedcounter = Integer.parseInt(counter.getTag().toString());
        if (gamestate[tapedcounter] == 2 && gameactive) {
            gamestate[tapedcounter] = activeplayer;

            counter.setTranslationY(-1000);

            counter.animate().translationYBy(1000).rotationYBy(3600).setDuration(1000);

            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activeplayer = 0;
            }
            for (int[] winpo : winpos) {

                if (gamestate[winpo[0]] == gamestate[winpo[1]] && gamestate[winpo[1]] == gamestate[winpo[2]] && gamestate[winpo[0]] != 2) {
                    gameactive = false;
                    String winneeplayer="";
                    if (activeplayer == 1) {
                        winneeplayer="YELLOW HAS WON";


                    } else {
                        winneeplayer="RED HAS WON ";


                    }
                    TextView winner = (TextView) findViewById(R.id.winner);
                    Button again = (Button) findViewById(R.id.again);
                    winner.animate().setDuration(1000);
                    winner.setText(winneeplayer);
                    if (activeplayer == 1) {

                        winner.setTextColor(this.getResources().getColor(R.color.yellow));


                    } else {
                        winner.setTextColor(this.getResources().getColor(R.color.red));


                    }
                    again.setVisibility(View.VISIBLE);
                    winner.setVisibility(View.VISIBLE);}
            }
        }
    }

        public void again (View view){
            TextView winner = (TextView) findViewById(R.id.winner);
            Button again = (Button) findViewById(R.id.again);
            again.setVisibility(View.INVISIBLE);
            winner.setVisibility(View.INVISIBLE);
            //GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
           // for (int i = 0; i < gridLayout.getChildCount(); i++) {
             //  ImageView counter = (ImageView) gridLayout.getChildAt(i);
              // counter.setImageDrawable(null);
            //}
            ImageView imageView1=findViewById(R.id.imageView1);
            ImageView imageView2=findViewById(R.id.imageView2);
            ImageView imageView3=findViewById(R.id.imageView3);
            ImageView imageView4=findViewById(R.id.imageView4);
            ImageView imageView5=findViewById(R.id.imageView5);
            ImageView imageView6=findViewById(R.id.imageView6);
            ImageView imageView7=findViewById(R.id.imageView7);
            ImageView imageView8=findViewById(R.id.imageView8);
            ImageView imageView9=findViewById(R.id.imageView9);
            imageView1.setImageDrawable(null);
            imageView2.setImageDrawable(null);
            imageView3.setImageDrawable(null);
            imageView4.setImageDrawable(null);
            imageView5.setImageDrawable(null);
            imageView6.setImageDrawable(null);
            imageView7.setImageDrawable(null);
            imageView8.setImageDrawable(null);
            imageView9.setImageDrawable(null);

            for (int i = 0; i < gamestate.length; i++) {
                gamestate[i] = 2;

            }
            activeplayer = 0;

            gameactive = true;
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
