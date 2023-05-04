package com.example.texted_app;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.rpc.context.AttributeContext;

public class contacts_class extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser currentUser = mAuth.getCurrentUser();
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    // We declare two buttons
    Button bAddContButt, bLogOutButt;

    //We create the label inputs
   TextView showUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);

        bAddContButt = findViewById(R.id.add_contact);
        bLogOutButt = findViewById(R.id.log_out);
        showUserId = findViewById(R.id.showUserId);

        getUserId();

        // We initialize the "Add Contact" button
        bAddContButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the button is clicked, it will open the "New Contact" screen
                Intent intent  = new Intent(contacts_class.this, newcontact_class.class);
                startActivity(intent);
            }
        });

        // We initialize the "Log Out" button
        bLogOutButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the button is clicked, it will log out the user and go back to the "Main" screen
                Intent intent = new Intent(contacts_class.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }

    public void getUserId(){
        showUserId = findViewById(R.id.showUserId);

        DocumentReference docRef = db.collection("users").document(currentUser.getEmail());

        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String username1= documentSnapshot.getString("fullName"); // Almacenamos el username en el array
                    showUserId.setText(username1);
                    Log.d(TAG, "Username: " + username1);

                } else {
                    Log.d(TAG, "No such document");
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "Error getting document: " + e.getMessage());
            }
        });
    }

}
