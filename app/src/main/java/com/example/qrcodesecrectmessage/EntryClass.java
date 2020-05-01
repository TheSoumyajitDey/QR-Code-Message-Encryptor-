package com.example.qrcodesecrectmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EntryClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_class);

        final EditText editText = (EditText)findViewById(R.id.secrectText);
        Button button = (Button)findViewById(R.id.nextPage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntryClass.this,MainActivity.class);
                String theSecrectString = editText.getText().toString();
                if(theSecrectString.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Message Can not be empty",Toast.LENGTH_LONG).show();

                }else {
                    intent.putExtra("Secrect",theSecrectString);
                    startActivity(intent);
                }

            }
        });
    }
}
