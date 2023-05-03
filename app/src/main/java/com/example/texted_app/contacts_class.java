package com.example.texted_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class contacts_class extends AppCompatActivity {

    // We declare two buttons
    Button bAddContButt, bLogOutButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);

        // We initialize the "Add Contact" button
        bAddContButt = findViewById(R.id.add_contact);
        bAddContButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the button is clicked, it will open the "New Contact" screen
                Intent intent  = new Intent(contacts_class.this, newcontact_class.class);
                startActivity(intent);
            }
        });

        // We initialize the "Log Out" button
        bLogOutButt = findViewById(R.id.log_out);
        bLogOutButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the button is clicked, it will log out the user and go back to the "Main" screen
                Intent intent = new Intent(contacts_class.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
