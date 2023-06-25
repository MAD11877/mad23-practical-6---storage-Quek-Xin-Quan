package sg.edu.np.mad.madpractical;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class MyDBHandler extends SQLiteOpenHelper {
    String title ="MyDbHandler";
    public static int DATABASE_VERSION =1;

    public static String DATABASE_NAME = "userDb.db";
    public static String USERS = "Users";
    public static String COLUMN_NAME = "Name";
    public static String COLUMN_DESCRIPTION = "Description";
    public static String COLUMN_ID = "id";
    public static String COLUMN_FOLLOWED = "Followed";

    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " +  USERS+"(" + COLUMN_NAME+" TEXT," + COLUMN_DESCRIPTION +"Text," + COLUMN_ID +"Text," + COLUMN_FOLLOWED +"Text"+")";
        Log.v(title,CREATE_USER_TABLE);
        db.execSQL(CREATE_USER_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+USERS);
        onCreate(db);
    }
    public void addUser (User user)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_DESCRIPTION,user.getDescription());
        values.put(COLUMN_ID,user.getId().toString());
        values.put(COLUMN_FOLLOWED,user.getFollowed().toString());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(USERS, null,values);
        Log.v(title,"Inserted");
        db.close();
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM " + USERS;
        Log.v(title, "Query: " + query);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setName(cursor.getColumnName(0));
                user.setDescription(cursor.getColumnName(1));
                user.setId(Integer.parseInt(cursor.getColumnName(2)));
                user.setFollowed(Boolean.parseBoolean(cursor.getColumnName(3)));
                userList.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return userList;
    }
    public void updateUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FOLLOWED, user.getFollowed());
        db.update(USERS,values, COLUMN_NAME + " = " + user.getName(),null);
        db.close();

    }

}
