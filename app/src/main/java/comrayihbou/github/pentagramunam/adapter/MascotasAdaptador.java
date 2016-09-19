package comrayihbou.github.pentagramunam.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import comrayihbou.github.pentagramunam.DB.ConstructorMascotas;
import comrayihbou.github.pentagramunam.Principal.DetalleMascota;
import comrayihbou.github.pentagramunam.pojo.Mascotas;
import comrayihbou.github.pentagramunam.R;

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotasViewHolder> {


    ArrayList<Mascotas> mascotas;
    Activity activity;

    //Este metodo construye la lista de contacto.
    //Se agrega la variable activity al constructor.
    public MascotasAdaptador(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

    }

    @Override
    public MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota, parent, false);
        return new MascotasViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final MascotasViewHolder mascotasViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);
        //mascotasViewHolder.imgFoto.setImageResource(mascota.getFoto());
        //mascotasViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotasViewHolder.tvLikesCV.setText(String.valueOf(mascota.getLikes()) + " Likes");

        mascotasViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascota.class);
                //intent.putExtra("nombre", mascota.getNombre());
                intent.putExtra("likes", mascota.getLikes());
                intent.putExtra("foto", mascota.getUrlFoto());
                activity.startActivity(intent);
            }
        });

        /*
        mascotasViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();



                //Codigo para utilizar el metodo darLikeMascota usado en nuestra clase BaseDatos
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);

                //Obtener el textView de tvLikes para generar el Like y sumarlo a la BD
                mascotasViewHolder.tvLikesCV.setText("" + constructorMascotas.obtenerLikesMascotas(mascota) + " Likes");

            }
        });
        */
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        //private TextView tvNombreCV;
        private TextView tvLikesCV;
        //private ImageButton btnLike;


        public MascotasViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            //tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvLikesCV = (TextView) itemView.findViewById(R.id.tvLikesCV);
            //btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);



        }
    }
}
