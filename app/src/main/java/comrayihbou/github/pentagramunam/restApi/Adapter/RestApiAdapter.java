package comrayihbou.github.pentagramunam.restApi.Adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import comrayihbou.github.pentagramunam.restApi.ConstantesRestApi;
import comrayihbou.github.pentagramunam.restApi.EndPointApi;
import comrayihbou.github.pentagramunam.restApi.Model.MascotaResponse;
import comrayihbou.github.pentagramunam.restApi.deserializador.MascotaDeserializador;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rabihbouorm on 9/19/16.
 */
public class RestApiAdapter {

    //Adaptador para generar la conexion con nuestro web service
    public EndPointApi establecerConexionRestApiInstagram(Gson gson){
        //Generamos la llamada al web service
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //Podemos solicitar los datos por separado con el GsonFactory

        return retrofit.create(EndPointApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        //Metodo que nos ayuda a asociar lo deserializado al gson
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());

        return gsonBuilder.create();

    }

}
