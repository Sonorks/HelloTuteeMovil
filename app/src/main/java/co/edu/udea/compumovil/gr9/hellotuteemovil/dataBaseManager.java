package co.edu.udea.compumovil.gr9.hellotuteemovil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by telematica on 4/03/16.
 */
public class dataBaseManager {
    public static final String tableName = "participantes";
    public static final String cn_id = "_id";
    public static final String cn_email = "correo";
    public static final String cn_password = "contraseña";
    public static final String cn_name = "nombre";
    public static final String cn_user = "usuario";
    public static final String cn_perfil ="perfil";
    public static final String tableNameLogin = "login";
    public static final String cn_userLogin = "user";

    public static final String CREATE_TABLE = "create table " +tableName+ " ("

            + cn_id + " integer primary key autoincrement,"

            + cn_name + " text not null," + cn_password + " text not null," + cn_email + " text not null,"

            + cn_user + " text not null,"

            + cn_perfil + " text not null);";

    public static final String CREAR_TABLA = "create table "+tableNameLogin+" ("
            +cn_userLogin+ " text not null);";

    private DbHelper helper;
    private dbHelperLogin loginHelper;
    public static SQLiteDatabase db;
    public static SQLiteDatabase dbLogin;
    public dataBaseManager(Context context) { //el constructor

        helper = new DbHelper(context);
        loginHelper = new dbHelperLogin(context);
        db = helper.getWritableDatabase();
        dbLogin=loginHelper.getWritableDatabase();

    }

    private ContentValues generarContentValues(String nombre, String contraseña, String correo, String usuario, String perfil) {

        ContentValues valores = new ContentValues();

        valores.put(cn_name, nombre);

        valores.put(cn_password, contraseña);

        valores.put(cn_email, correo);

        valores.put(cn_user,usuario);

        valores.put(cn_perfil,perfil);

        return valores;

    }
    private ContentValues generarContentValuesLogeo(String user) {

        ContentValues valores = new ContentValues();

        valores.put(cn_userLogin, user);

        return valores;

    }
    public void insertarLogeo(String user) {

        //bd.insert(TABLA, NullColumnHack, ContentValues);

        dbLogin.insert(tableNameLogin, null, generarContentValuesLogeo(user));

    }

    public void insertar(String nombre, String contraseña, String correo, String usuario, String perfil) {

        //bd.insert(TABLA, NullColumnHack, ContentValues);

        db.insert(tableName, null, generarContentValues(nombre, contraseña, correo, usuario, perfil));

    }


    public void eliminar(String usuario) {

        db.delete(tableName, cn_name + "=?", new String[]{usuario});

    }
    public void deslogear(String usuario) {
        System.out.println("Elimine a "+usuario);
        dbLogin.delete(tableNameLogin, cn_userLogin + "=?", new String[]{usuario});

    }

    public void eliminarMultiple(String us1, String us2) {

        db.delete(tableName, cn_name + "IN (?,?)", new String[]{us1,us2});

    }


    public Cursor cargarCursorUsuarioLogeo() {
        String[] columnas2 = new String[]{cn_userLogin};

        return dbLogin.query(tableNameLogin, columnas2, null, null, null, null, null);

    }
    public Cursor cargarCursorUsuario(String username) {
        String[] columnas = new String[]{cn_id,cn_name,cn_password,cn_email,cn_user,cn_perfil};

        return db.query(tableName, columnas,cn_user+"=?", new String[]{username}, null, null, null);

    }
    public boolean buscarUsuarioCursor(String user,String contraseña) {
        String password="";
        String[] columnas;
        columnas = new String[]{cn_id,cn_name,cn_password,cn_email,cn_user,cn_perfil};
        Cursor c = db.query(tableName, columnas, cn_user + "=?", new String[]{user}, null, null, null);
        if(c.moveToFirst()){
            do{
                String a = c.getString(4);
                if (a.equals(user)){
                    password = c.getString(2);
                }
            }
            while(c.moveToNext());
        }
        if (password.equals(contraseña)){
            return true;
        }
        return false;

    }
}
