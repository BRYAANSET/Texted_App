package com.example.texted_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class register_class extends AppCompatActivity {

    Button bSignUpButt, bSignInButt;
    ImageButton bBackMainButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        //Button sign up
        bSignUpButt = findViewById(R.id.button_log_in);
        bSignUpButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register_class.this, contacts_class.class);
                startActivity(intent);
            }
        });

        //Already hav an account button
        bSignInButt = findViewById(R.id.acc_sign_in);
        bSignInButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register_class.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Back to login screen button
        bBackMainButt = findViewById(R.id.back_arrow_createac);
        bBackMainButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register_class.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
