package comrayihbou.github.pentagramunam.Principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import comrayihbou.github.pentagramunam.R;
import comrayihbou.github.pentagramunam.adapter.MascotasAdaptador;
import comrayihbou.github.pentagramunam.pojo.Mascotas;


public class DetalleMascota extends AppCompatActivity {
/*
    private TextView tvNombre;
    private TextView tvLikes;
    ArrayList<Mascotas> mascotas;
    private RecyclerView ListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        ListaMascotas = (RecyclerView) findViewById(R.id.rvLikes);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();


        //BUNDLE
        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.NombreMascotas));
        String likes = parametros.getString(getResources().getString(R.string.NumeroLikes));




    }

    public MascotasAdaptador adaptador;

    public void inicializarAdaptador() {

        adaptador = new MascotasAdaptador(mascotas, this);
        ListaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {

        //Constructor para indentificar el Arraylist como la variable contactos, utilizando todas las variables de la Clase Mascotas.java .
        mascotas = new ArrayList<Mascotas>();

        //Creando Contactos
        mascotas.add(new Mascotas(R.drawable.perro, "Perro", 0));
        mascotas.add(new Mascotas(R.drawable.gato, "Gato", 0));
        mascotas.add(new Mascotas(R.drawable.conejo, "Conejo", 0));
        mascotas.add(new Mascotas(R.drawable.hamster, "Hamster", 0));
        mascotas.add(new Mascotas(R.drawable.pez, "Pez", 0));
    }

    */
}
