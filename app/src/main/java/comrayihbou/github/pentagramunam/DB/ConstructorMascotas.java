package comrayihbou.github.pentagramunam.DB;

//Construir las diferentes vistas de contactos necesarias (El interactor entre la Base de Datos y la interfaz)
//Clase clave para estar switchiando la base de datos

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import comrayihbou.github.pentagramunam.R;
import comrayihbou.github.pentagramunam.pojo.Mascotas;

public class ConstructorMascotas {

    private static final int LIKE = 1 ;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context=context;
    }

    public ArrayList<Mascotas> obtenerDatos(){

        /* //Constructor para indentificar el Arraylist como la variable mascotas, utilizando todas las variables de la Clase Mascotas.java .
        ArrayList<Mascotas>  mascotas = new ArrayList<Mascotas>();

        //Creando Contactos
        mascotas.add(new Mascotas(R.drawable.perro, "Perro", 0));
        mascotas.add(new Mascotas(R.drawable.gato, "Gato", 0));
        mascotas.add(new Mascotas(R.drawable.conejo, "Conejo", 0));
        mascotas.add(new Mascotas(R.drawable.hamster, "Hamster", 0));
        mascotas.add(new Mascotas(R.drawable.pez, "Pez", 0));

        return mascotas; */

        //Metodo para realizar la conexcion a la base de datos en vez de crear un ArrayList
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return  db.obtenerTodosLasMascotas();
    }

    //Metodo para rellenar la base de datos
    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Perro");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Gato");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.gato);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Conejo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.conejo);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Hamster");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.hamster);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pez");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pez);

        db.insertarMascotas(contentValues);

    }

    //Metodo para crear el sumador de los likes en las mascotas
    public void darLikeMascota(Mascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS, mascotas.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES, LIKE);
        db.insertarLikeMascotas(contentValues);
    }

    //Metodo para obtener los likes de la Base de datos para mostrarlo en el TextView
    //Este metodo es creado en la clase BaseDatos.java
    public int obtenerLikesMascotas(Mascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascotas(mascotas);

    }

}
