package com.example.board;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class Welcome extends AppCompatActivity {
ImageView imageViewd1,imageViewd2;
Button button;
MediaPlayer mediaPlayer_dice;
int []DiceImages = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageViewd1=findViewById(R.id.imageDice1);
        imageViewd2=findViewById(R.id.imageDice2);
        button = findViewById(R.id.btnRollTheDice);
        mediaPlayer_dice = MediaPlayer.create(this,R.raw.dice_sound);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Random random= new Random();
               int random_number=random.nextInt(6);
               imageViewd1.setImageResource(DiceImages[random_number]);

                int random_number_1=random.nextInt(6);
               imageViewd2.setImageResource(DiceImages[random_number_1]);
               YoYo.with(Techniques.RollIn)
                       .duration(500)
                       .repeat(2)
                       .playOn(imageViewd1);

               YoYo.with(Techniques.RollIn)
                       .duration(500)
                       .repeat(2)
                       .playOn(imageViewd2);
               mediaPlayer_dice.start();
           }
       });
    }
}