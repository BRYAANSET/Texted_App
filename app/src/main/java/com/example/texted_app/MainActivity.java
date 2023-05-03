package com.example.texted_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.texted_app.databinding.ActivityMainBinding;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    //We create the action buttons
    Button bloginButt, bsigninButt;

    //We create the label inputs
    EditText MainInpmail, MainInpPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //We match the new buttons with their layout id
        MainInpmail = findViewById(R.id.mainInputMail);
        MainInpPass = findViewById(R.id.mainInputPass);
        bloginButt = findViewById(R.id.button_log_in);
        bsigninButt = findViewById(R.id.sign_in);


        //On click login function
        bloginButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Setting variables into an string
                String email = MainInpmail.getText().toString().trim();
                String password = MainInpPass.getText().toString().trim();

                //Conditional to empty fields
                if (TextUtils.isEmpty(email)) {
                    MainInpmail.setError("Enter the email");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    MainInpPass.setError("Enter the password");
                    return;
                }
                //Firebase autentication function
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                           @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(MainActivity.this, contacts_class.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    //We display a message if
                                    Toast.makeText( MainActivity.this, "No se pudo iniciar sesión, compruebe sus datos y vuelva a intentarlo", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });


        //We initialize the "sign in" button

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
