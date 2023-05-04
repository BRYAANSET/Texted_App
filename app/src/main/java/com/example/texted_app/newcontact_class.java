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

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class newcontact_class extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    //We create the action buttons
    ImageButton bBackToContButt;
    Button bAddContButt;

    //We create the label inputs
    EditText addNewMail, addFullName;

    String currentUserEmail = currentUser.getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact);

        //We match the new buttons with their layout id
        bBackToContButt = findViewById(R.id.back_arrow_createac);
        bAddContButt = findViewById(R.id.button_add_contact);
        addNewMail = findViewById(R.id.add_eMail);
        addFullName = findViewById(R.id.add_fullName);

        bBackToContButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(newcontact_class.this, contacts_class.class);
                startActivity(intent);
            }
        });

        bAddContButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newContactEmail = addNewMail.getText().toString();
                String newContactName = addFullName.getText().toString();

                RegisterNewFriend(newContactEmail, newContactName);

            }
        });

    }

    public void RegisterNewFriend(String newContactEmail, String newContactName) {



        // Sign in success, update UI with the signed-in user's information
        FirebaseUser user = mAuth.getCurrentUser();
        Map<String, Object> uData = new HashMap<>();

        uData.put("email", newContactEmail);
        uData.put("fullName", newContactName);

        db.collection("users").document(user.getEmail().toString()).collection("contacts").document(newContactEmail).set(uData);
        Toast.makeText(newcontact_class.this, "User has been created succesfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(newcontact_class.this, newcontact_class.class);
        startActivity(intent);

    }
}
