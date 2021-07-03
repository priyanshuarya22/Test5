package com.example.test5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //initialising variables
    Button b1;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creatig objects
        b1 = findViewById(R.id.a1_b1);
        iv1 = findViewById(R.id.a1_iv1);
        //setting listener to select button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating a new intent to get content from os
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                //setting intent type
                intent.setType("image/*");
                //sending the intent with a request code 1
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //checking if the request code match with our request and that the request is not empty
        if(requestCode == 1 && resultCode == Activity.RESULT_OK) {
            //setting the image on image view
            iv1.setImageURI(data.getData());
        }
    }
}