package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button[] button=new Button[11];
    TextView nextmove,X_score,O_score;
    int score_x=0;
    int score_o=0;
    boolean won=false;
    String [] squares=new String[9];
    boolean turn=false;
    String winner="";

    public String Calculate(String squares[])
    {
        int win[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        for(int i=0;i<8;i++)
        {
            if(squares[win[i][0]]!=null&&squares[win[i][1]]==squares[win[i][0]]&&squares[win[i][2]]==squares[win[i][0]])
            {
                return squares[win[i][0]];
            }
        }
        return "";
    }
    public void applylogic(int a)
        {
            if(won||squares[a]!=null)
                return ;
            button[a].setText((turn?"O":"X"));
            squares[a]=(turn?"O":"X");
            turn=!turn;
            nextmove.setText("Next Move:"+(turn?"O":"X"));
            winner=Calculate(squares);
                if(winner!="")
                {
                    won=true;
                   Toast.makeText(this, winner, Toast.LENGTH_SHORT).show();
                   clear();
                }
           }
    public void clear()
    {
        //button[0].setText("X");
        //button[1].setText("0");
        for(int i=0;i<9;i++)
        {
            button[i].setText("");
        }

    }

    public void reset()
    {
        clear();
        score_o=0;
        score_x=0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button[0]=findViewById(R.id.button);
        button[1]=findViewById(R.id.button5);
        button[2]=findViewById(R.id.button7);
        button[3]=findViewById(R.id.button8);
        button[4]=findViewById(R.id.button9);
        button[5]=findViewById(R.id.button10);
        button[6]=findViewById(R.id.button11);
        button[7]=findViewById(R.id.button12);
        button[8]=findViewById(R.id.button13);
        button[9]=findViewById(R.id.button14);
        button[10]=findViewById(R.id.button15);
        nextmove=findViewById(R.id.textView);
        X_score=findViewById(R.id.textView2);
        O_score=findViewById(R.id.textView3);
        for(int i=0;i<11;i++)
        {
            button[i].setTag(i);
            button[i].setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View v) {
        int i = (int) v.getTag();
        if(i == 9) clear();
        else if(i==10)
            reset();
        else
            applylogic(i);
      }
}
