package com.example.meeting_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    private String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit: {
                ChangeDialogVisibility();
                break;
            }
            case R.id.send: {
                if(!message.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    public void closeDialog(View view) {
        ChangeDialogVisibility();
    }

    public void saveMessage(View view) {
        EditText input = findViewById(R.id.messageInput);
        String message = input.getText().toString();
        this.message = message;
        SetTextToDisplay(message);
        ChangeDialogVisibility();
    }



    private void ChangeDialogVisibility() {
        RelativeLayout dialog = findViewById(R.id.dialog);
        if(dialog.getVisibility() == View.VISIBLE) {
            dialog.setVisibility(View.GONE);
        } else {
            dialog.setVisibility(View.VISIBLE);
        }
    }

    private void SetTextToDisplay(String message) {
        EditText display = findViewById(R.id.messageDisplay);
        display.setText(message);
    }
}