package co.edu.udea.compumovil.gr9.hellotuteemovil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by JULIAN on 27/03/2016.
 */
public class dataBasePreguntas {
    public static final String tableName = "preguntas";
    public static final String cn_id = "_id";
    public static final String cn_username ="usuario";
    public static final String cn_area ="area";
    public static final String cn_asignatura ="asignatura";
    public static final String cn_tema ="tema";
    public static final String cn_question = "pregunta";
    public static final String cn_status ="estado";

    public static final String CREATE_TABLE = "create table " +tableName+ " ("
            + cn_id + " integer primary key autoincrement,"
            + cn_username + " text not null,"
            + cn_area + " text not null,"
            + cn_asignatura + " text not null,"
            + cn_tema + " text not null,"
            + cn_question + " text not null,"
            + cn_status+ " text not null);";

    private dbPreguntasHelper helper;

    public static SQLiteDatabase db;

    public dataBasePreguntas(Context context) { //el constructor

        helper = new dbPreguntasHelper(context);

        db = helper.getWritableDatabase();

    }
    private ContentValues generarContentValues(String username, String area, String asignatura, String tema,String pregunta, String estado) {

        ContentValues valores = new ContentValues();
        valores.put(cn_username, pregunta);
        valores.put(cn_area, pregunta);
        valores.put(cn_asignatura, pregunta);
        valores.put(cn_tema, pregunta);
        valores.put(cn_question, pregunta);
        valores.put(cn_status, estado);

        return valores;

    }
    public void insertar(String username, String area, String asignatura, String tema,String pregunta, String estado) {

        db.insert(tableName, null, generarContentValues(username,area,asignatura,tema,pregunta, estado));

    }
    public void eliminar(String pregunta) {

        db.delete(tableName, cn_question + "=?", new String[]{pregunta});

    }

    public Cursor cargarCursorPreguntas() {
        String[] columnas = new String[]{cn_id,cn_username,cn_area,cn_asignatura,cn_tema,cn_question,cn_status};
        return db.query(tableName, columnas, null, null, null, null, null);
    }

}
