package comrayihbou.github.pentagramunam.restApi;

/**
 * Created by rabihbouorm on 9/19/16.
 */
public class ConstantesRestApi {

    //Url Base Usada en cuanto al postman con el cual obtenemos toda la info de nuestro web service

    //https://api.instagram.com/v1/
    public static final String Vesion = "/v1";
    public static final String ROOT_URL = "https://api.instagram.com" + Vesion;
    public static final String ACCESS_TOKEN = "3929345390.b99e935.b540ad31d315405f94bd4e7ea15959b5";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN






}
