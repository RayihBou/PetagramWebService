package comrayihbou.github.pentagramunam.DB;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import comrayihbou.github.pentagramunam.pojo.Mascotas;

//Con la extension SQLiteOpenHelper entramos a la configuracion de la base de datos, en la opcion factory del constructor creado colocamos null
//En la clase ConstantesBaseDatos definimos el nombre y la version de la base de datos
//Esta clase es el interactor de la base de datos, en donde definimos todos los metodos a utilizar y la conexcion requerida para la misma

public class BaseDatos extends SQLiteOpenHelper{

    private Context context;

    //En este metodo implementamos los datos ingresados en la clase ConstatesBaseDatos
    //Ademas de ello maneja todos los datos ingresados en la base de datos
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATASBASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    //En este metodo se crea la estructura de la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota        = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS                      + "(" +
                                            ConstantesBaseDatos.TABLE_MASCOTAS_ID                                       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE                                   + " TEXT, " +
                                            ConstantesBaseDatos.TABLE_MASCOTAS_FOTO                                     + " INTEGER" +
                                            ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS                 + "(" +
                                            ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID                                 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS                        + " INTEGER, " +
                                            ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES                       + " INTEGER, " +
                                            "FOREIGN KEY ("+ ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS       + ")" +
                                            "REFERENCES "+ ConstantesBaseDatos.TABLE_MASCOTAS                           + "("+ConstantesBaseDatos.TABLE_MASCOTAS_ID+ ")" +
                                            ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);

    }

    //Metodo para Restructurar la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS);
        onCreate(db);
    }

    //Metodo que ejecutara una consulta a la base de datos
    public ArrayList<Mascotas> obtenerTodosLasMascotas(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        //Recorido en la base de datos
        while (registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES+") as likes " +
                                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else{
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);

        }

        //Es importante cerrar la conexcion despues de cada consulta
        db.close();
        return mascotas;
    }

    //Definir metodo para insertar los datos en la base de datos que sera usado en el ConstructorMascotas.java
    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    //Metodo para generar los likes en las mascotas
    public void insertarLikeMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS, null, contentValues);
        db.close();
    }

    //Query para generar la suma de contactos
    public int obtenerLikesMascotas(Mascotas mascotas){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES+")"+
                       " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                       " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + "=" + mascotas.getId();

        //Metodo para escribir la base de datos
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor para manejar la base de datos
        Cursor registros = db.rawQuery(query, null);

        //Como es la unica columna que estamos manejando el indice en el getInt es 0
        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }


}
