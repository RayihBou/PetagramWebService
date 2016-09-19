package comrayihbou.github.pentagramunam.restApi;

import comrayihbou.github.pentagramunam.restApi.Model.MascotaResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rabihbouorm on 9/19/16.
 */
public interface EndPointApi {

    //Este metodo nos devuelve un arreglo de imagenes de nuesto web service
    //Podemos usar jsonViewer para saber como esta conformado nuestros arreglos del web service

    //Normas para accesar a la info del web service
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();

}
