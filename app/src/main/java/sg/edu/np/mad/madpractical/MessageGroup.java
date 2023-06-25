package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MessageGroup extends AppCompatActivity {

    final String TITLE = "Message Group";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

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
        Button group1Button;
        Button group2Button;
        group1Button = findViewById(R.id.button3);
        group2Button = findViewById(R.id.button4);
        group1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, Group1.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
                Log.v(TITLE,"group 1 pressed");
            }
        });
        group2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, Group2.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
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