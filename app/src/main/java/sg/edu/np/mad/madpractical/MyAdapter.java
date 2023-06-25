package sg.edu.np.mad.madpractical;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.usb.UsbRequest;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    final String TITLE = "Adapter";
    ArrayList<User> data;
    public MyAdapter(ArrayList<User> input)
    {
        data = input;
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position).getName().endsWith("7"))
        {
            Log.v(TITLE,data.get(position).getName());
            return 0;
        }
        else
        {
            return 1;
        }

    }


    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        if (viewType==0)
        {
            Log.v(TITLE,"viewType" + viewType);
            Log.v(TITLE,"createview2");
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_view2,parent,false);
            MyViewHolder viewHolder = new MyViewHolder(item);
            return viewHolder;
        }
        else
        {
            Log.v(TITLE,"viewType" + viewType);
            Log.v(TITLE,"createview1");
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_view,parent,false);
            return new MyViewHolder(item);
        }

    }

    public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.txt1.setText(data.get(position).getName());
        holder.txt2.setText(data.get(position).getDescription());

        holder.myimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Image pressed.");
                imageAlert(v, position);

            }
        });

    }


    public int getItemCount() {
        return data.size();
    }
    private void imageAlert(View v,int position){

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Profile");
        builder.setMessage(data.get(position).getName());
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                intent.putExtra("name",data.get(position).getName());
                intent.putExtra("description",data.get(position).getDescription());
                intent.putExtra("id",data.get(position).getId());
                intent.putExtra("followed",data.get(position).getFollowed());
                v.getContext().startActivity(intent);
                Log.v(TITLE,"Alert pressed");
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //((Activity)v.getContext()).finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
