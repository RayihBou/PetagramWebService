package comrayihbou.github.pentagramunam.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import comrayihbou.github.pentagramunam.DB.ConstructorMascotas;
import comrayihbou.github.pentagramunam.fragment.iRecyclerViewFragmentView;
import comrayihbou.github.pentagramunam.pojo.Mascotas;
import comrayihbou.github.pentagramunam.restApi.Adapter.RestApiAdapter;
import comrayihbou.github.pentagramunam.restApi.EndPointApi;
import comrayihbou.github.pentagramunam.restApi.Model.MascotaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecyclerViewFragmentPresenter implements iRecyclerViewFragmentPresenter {

    private iRecyclerViewFragmentView IRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;

    //Constructor
    public RecyclerViewFragmentPresenter(iRecyclerViewFragmentView IRecyclerViewFragmentView, Context context) {
        this.IRecyclerViewFragmentView=IRecyclerViewFragmentView;
        this.context=context;
        //obtenerMascotasBaseDatos();
        obtenerMediosRecientes();
    }


    //DataBase
    @Override
    public void obtenerMascotasBaseDatos() {
        //contructor para hacer crear al metodo que estamos importando los datos de la base de datos, realmente se tienen en un constructor
        constructorMascotas = new ConstructorMascotas(context);

        //Obtener datos solicitados del Arraylist
        mascotas = constructorMascotas.obtenerDatos();

        mostrarMascotasRV();

    }

    //WebService
    @Override
    public void obtenerMediosRecientes() {

        //Ejecutamos el metodo de conexion
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        //Ejecutamos la llamada (GetrecentMedia)
        Call<MascotaResponse> mascotaResponseCall = endPointApi.getRecentMedia();

        //Controlamos los eventos de la peticion
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                //Obtenemos la info del cuerpo del Json
                MascotaResponse mascotaResponse = response.body();
                //Aplicamos la info al arraylist
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Falla de conexion! Intentar nuevamente", Toast.LENGTH_SHORT).show();
                Log.e("Falla de conexion", t.toString());
            }
        });


    }

    //DataBase
    @Override
    public void mostrarMascotasRV() {
        IRecyclerViewFragmentView.inicializarAdaptadorRV(IRecyclerViewFragmentView.crearAdaptador(mascotas));
        //IRecyclerViewFragmentView.generarLinerLayoutVertical();
        IRecyclerViewFragmentView.generarGridLayout();

    }

}
