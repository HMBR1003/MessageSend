package org.androidtown.messagesend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    InputFilter[] filter=new InputFilter[1];
    EditText text;
    String s;
    TextView view;
    TextWatcher watcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            view.setText(text.length()+" / 80 바이트");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filter[0]=new InputFilter.LengthFilter(80);
        view=(TextView)findViewById(R.id.textView);
        text=(EditText)findViewById(R.id.editText);
        text.addTextChangedListener(watcher);
        text.setFilters(filter);
    }

    public void closeClick(View v){
        finish();
    }

    public void sendClick(View v){
        s=text.getText().toString();
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();

    }
}
