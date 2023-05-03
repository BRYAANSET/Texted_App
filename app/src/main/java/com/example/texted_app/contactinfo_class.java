package com.example.texted_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class contactinfo_class extends AppCompatActivity {


    ImageButton bBacktoContButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_info);

        bBacktoContButt = findViewById(R.id.back_arrow_createac);
        bBacktoContButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contactinfo_class.this, contacts_class.class);
                startActivity(intent);
            }
        });

    }

}
