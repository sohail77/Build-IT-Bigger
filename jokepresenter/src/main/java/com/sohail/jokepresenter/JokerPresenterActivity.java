package com.sohail.jokepresenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokerPresenterActivity extends AppCompatActivity {


    private static final String JOKE = "joke";

    public static Intent launchIntent(Context context, String joke) {
        Intent intent = new Intent(context, JokerPresenterActivity.class);
        intent.putExtra(JOKE, joke);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker_presenter);
        String joke = getIntent().getStringExtra(JOKE);
        if (joke == null)
            joke = "Poor joke was null. Nobody cares :(";

        TextView textView = (TextView) findViewById(R.id.joke);
        textView.setText(joke);
    }
}
