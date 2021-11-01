package com.example.reddit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Button btnLogin;
    private Button btnContinue;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.v("lifecycle","onCreate");

        btnLogin=(findViewById(R.id.btn_Login));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Logheaza-te",Toast.LENGTH_LONG).show();
                Intent newWindow= new Intent(MainActivity2.this,MainActivity.class);
                startActivity(newWindow);
            }
        });
        btnContinue=findViewById(R.id.btn_Continue);
        etEmail=findViewById(R.id.textBox_Email);
        etUsername=findViewById(R.id.tb_Username);
        etPassword=findViewById(R.id.tb_Password);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()) {
                    Utilizator u1 = new Utilizator();
                    u1.setEmail(etEmail.getText().toString());
                    u1.setUsername(etUsername.getText().toString());
                    u1.setPassword(etPassword.getText().toString());
                    Bundle wrapperObject = new Bundle();
                    wrapperObject.putSerializable("User", u1);
                    Intent intent= new Intent();
                    intent.putExtra("raspunsBundle", wrapperObject);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("lifecycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("lifecycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("lifecycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v("lifecycle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("lifecycle","onDestroy");
    }

    boolean isEmailValid(CharSequence email)
    {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValid()
    {
        if(etEmail.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity2.this, "Completati email-ul",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(etUsername.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity2.this, "Completati numele de utilizator",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(etPassword.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity2.this, "Completati parola",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!isEmailValid(etEmail.getText().toString()))
        {
            Toast.makeText(MainActivity2.this, "Email invalid",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;

    }

}