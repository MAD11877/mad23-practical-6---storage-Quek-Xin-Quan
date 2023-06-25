package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    final String TITLE = "List Activity";
    ArrayList<User> userList = new ArrayList<>();
    MyDBHandler myDBHandler = new MyDBHandler(this,null,null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        createUser();
        for (User i: userList) {
            myDBHandler.addUser(i);
        }
        Log.v(TITLE,"created users");
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        MyAdapter myAdapter = new MyAdapter(myDBHandler.getUsers());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);

    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start:");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TITLE, "On Resume:");

        /*ImageView image;

        image = findViewById(R.id.imageView);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Image pressed.");
                imageAlert();

            }
        });*/

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

    private void imageAlert(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                int num = generateRanNum();
                Intent myIntent = new Intent(ListActivity.this,MainActivity.class);
                myIntent.putExtra("ran number",num);
                startActivity(myIntent);
                Log.v(TITLE,"random number: " + num);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
    private int generateRanNum(){
        Random ran = new Random();
        int myNumber = ran.nextInt(99999999);
        return myNumber;
    };
    private void createUser(){
        for (int i = 1; i<=20;i++) {
            Random bool = new Random();
            User user1 = new User("Name" + generateRanNum(), "Description " + generateRanNum(), i, bool.nextBoolean());
            userList.add(user1);
        }
    }
}