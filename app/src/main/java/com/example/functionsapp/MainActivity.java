package com.example.functionsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //initializee variables
    EditText editTEmail, editTPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize views
        editTEmail = findViewById(R.id.editTEmail);
        editTPassword = findViewById(R.id.editTPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btnLogin)){
            // validate credentials
            if (validated()){
                // login
                String email = editTEmail.getText().toString();
                String password = editTPassword.getText().toString();

                // login the user
                loginUser(email, password);
            }

        }

    }

    private void loginUser(String email, String password) {
        if (email.equals("abc@gmail.com") && password.equals("12345")){
            Toast.makeText(this, "You have been logged in successfully", Toast.LENGTH_SHORT).show();
            // go home function
            goHome();
        } else {
            Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
        }
    }

    private void goHome() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    private boolean validated() {
        if (TextUtils.isEmpty(editTEmail.getText().toString())) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(editTPassword.getText().toString())) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            editTPassword.setFocusable(true);
            return false;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(editTEmail.getText().toString()).matches()){
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;


    }
}