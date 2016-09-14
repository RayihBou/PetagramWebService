package comrayihbou.github.pentagramunam.DB;

//En esta clase implementados las constantes a utilizar en nuestra base de datos


public final class ConstantesBaseDatos {

    public static final String DATASBASE_NAME = "mascotas";

    public static final int DATABASE_VERSION = 1;
    
    public static final String TABLE_MASCOTAS           = "mascotas";
    public static final String TABLE_MASCOTAS_ID        = "id";
    public static final String TABLE_MASCOTAS_NOMBRE    = "nombre";
    public static final String TABLE_MASCOTAS_FOTO      = "foto";

    public static final String TABLE_LIKES_MASCOTAS     = "mascota_likes";
    public static final String TABLE_LIKES_MASCOTAS_ID   = "id" ;
    public static final String TABLE_LIKES_MASCOTAS_ID_MASCOTAS = "id_mascota";
    public static final String TABLE_LIKES_MASCOTAS_NUMERO_LIKES = "numero_likes";
}
