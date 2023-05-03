package com.example.texted_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.texted_app.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //We create the action buttons
    Button bloginButt, bsigninButt;

    //We create the label inputs
    EditText MainInpmail, MainInpPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainInpmail = findViewById(R.id.mainInputMail);
        MainInpPass = findViewById(R.id.mainInputPass);

        //We initialize the "login" button
        bloginButt = findViewById(R.id.button_log_in);

        bloginButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(MainInpmail.getText());
                password = String.valueOf(MainInpPass.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this, "Enter email",Toast.LENGTH_SHORT).show();

                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "Enter password",Toast.LENGTH_SHORT).show();

                }

                // When the button is clicked, it will open the "contacts" screen
                Intent intent = new Intent(MainActivity.this, contacts_class.class);
                startActivity(intent);


            }
        });

        //We initialize the "sign in" button
        bsigninButt = findViewById(R.id.sign_in);
        bsigninButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the button is clicked, it will open the "register" screen
                Intent intent = new Intent(MainActivity.this, register_class.class);
                startActivity(intent);
            }
        });
    }

}
