package com.example.yelia.practice1_dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonTip = (Button)findViewById(R.id.buttonTip);
        buttonTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 实现提示对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Please click another button and login.").setTitle("Tip");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
            }
        });

        Button buttonLogin = (Button)findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 实现登录对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View loginView = inflater.inflate(R.layout.login_dialog, null);
                builder.setView(loginView).setTitle("Login")
                        .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                EditText editUsername = (EditText)loginView.findViewById(R.id.editUsername);
                                EditText editPassword = (EditText)loginView.findViewById(R.id.editPassword);
                                if (editUsername.getText().toString().equals("abc") &&
                                        editPassword.getText().toString().equals("123"))
                                    Toast.makeText(MainActivity.this, "Login Succeed", Toast.LENGTH_LONG).show();
                                else Toast.makeText(MainActivity.this, "ERROR Incorrect username or password", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
            }
        });
    }
}
