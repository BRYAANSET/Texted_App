package com.example.texted_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class newcontact_class extends AppCompatActivity {

    ImageButton bBackToContButt;
    Button bAddContButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact);

        bBackToContButt = findViewById(R.id.back_arrow_createac);
        bBackToContButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(newcontact_class.this, contacts_class.class);
                startActivity(intent);
            }
        });



    }

}
