package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String TITLE = "Main Activity";
    User user1;
    Button followButton;
    Button messageButton;
    MyDBHandler myDBHandler = new MyDBHandler(this,null,null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent myRecIntent = getIntent();

        int id;
        String name,description;
        boolean followed;

        id = myRecIntent.getExtras().getInt("id");

        Log.v(TITLE, "On Create:");
        name = myRecIntent.getStringExtra("name");
        description = myRecIntent.getStringExtra("description");
        followed = myRecIntent.getExtras().getBoolean("followed");
        TextView myTextview;
        Log.v(TITLE, "Name: "+name);
        myTextview = findViewById(R.id.textView);
        myTextview.setText(name);
        TextView myTextview2;
        myTextview2 = findViewById(R.id.textView2);
        myTextview2.setText(description);
        messageButton = findViewById(R.id.button2);
        user1 = new User(name,description,id,followed);
        followButton =findViewById(R.id.button);

        if (followed)
        {
            followButton.setText("Unfollow");
        }
        else
        {
            followButton.setText("Follow");
        }



    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start:");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TITLE, "On Resume:");
        followButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {
               if (user1.Followed)
               {
                   user1.Followed = false;
                   myDBHandler.updateUser(user1);
                   followButton.setText("Follow");
                   Log.v(TITLE,"follow");
                   Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();

               }
               else {
                   user1.Followed = true;
                   myDBHandler.updateUser(user1);
                   followButton.setText("Unfollow");
                   Log.v(TITLE,"Unfollow");
                   Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
               }

           }
        });
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE,"Message Button pressed");
                Intent messageGroup = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(messageGroup);
            }
        });
    }
    protected void onPause(){

        super.onPause();
        Log.v(TITLE, "On Pause:");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TITLE, "On Stop:");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TITLE, "On Destroy:");
    }

}