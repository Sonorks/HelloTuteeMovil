package co.edu.udea.compumovil.gr9.hellotuteemovil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JULIAN on 27/03/2016.
 */
public class dbHelperLogin extends SQLiteOpenHelper{
    public dbHelperLogin(Context context) {
        super(context, db_name, null, db_scheme_version);
    }

    private static final String db_name= "login";
    private static int db_scheme_version=1;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(dataBaseManager.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
