package com.example.texted_app;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;
import java.util.Map;

public class register_class extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    //We create the action buttons
    Button bSignUpButt, bSignInButt;
    ImageButton bBackMainButt;

    //We create the label inputs
    EditText emailInpReg, fullNameInpReg, passImpReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        //We match the new buttons with their layout id
        bSignUpButt = findViewById(R.id.button_sign_in);
        bSignInButt = findViewById(R.id.acc_log_in);
        bBackMainButt = findViewById(R.id.back_arrow_createac);
        emailInpReg = findViewById(R.id.text_email);
        fullNameInpReg = findViewById(R.id.full_name);
        passImpReg = findViewById(R.id.accCreate_pass);


        bSignUpButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInpReg.getText().toString();
                String password = passImpReg.getText().toString();
                String fullName = fullNameInpReg.getText().toString();

                registerUser(email, password, fullName);
            }
        });

    }

    public void registerUser(String email, String password, String fullName) {

        // Creating a new user with email and password using Firebase Authentication.
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // If user registration is successful, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            // Creating a new HashMap object to store user data.
                            Map<String,Object>uData = new HashMap<>();

                            // Adding email and full name of the user to the HashMap.
                            uData.put("email", email);
                            uData.put("fullName", fullName);

                            // Adding the user data to Firestore database under 'users' collection using email as the document id.
                            db.collection("users").document(user.getEmail().toString()).set(uData);

                            // Showing a success message using a Toast.
                            Toast.makeText( register_class.this, "User has been created succesfully", Toast.LENGTH_SHORT).show();

                            // Moving to the main activity using an Intent.
                            Intent intent = new Intent(register_class.this, MainActivity.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(register_class.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            // ...
                        }
                    }
                });
    }

}
