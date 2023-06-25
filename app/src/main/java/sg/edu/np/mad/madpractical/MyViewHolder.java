package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView myimageView;
    TextView txt1,txt2;
    ImageView imageView2;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        myimageView = itemView.findViewById(R.id.userviewImageView);
        txt1 = itemView.findViewById(R.id.name);
        txt2 = itemView.findViewById(R.id.description);
        imageView2 = itemView.findViewById(R.id.imageView2);

    }
}
