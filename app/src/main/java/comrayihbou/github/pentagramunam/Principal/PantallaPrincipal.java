package comrayihbou.github.pentagramunam.Principal;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import comrayihbou.github.pentagramunam.Menu.ActivityAcercaDe;
import comrayihbou.github.pentagramunam.Menu.ActivityContacto;
import comrayihbou.github.pentagramunam.R;
import comrayihbou.github.pentagramunam.adapter.PageAdapter;
import comrayihbou.github.pentagramunam.fragment.Perfil;
import comrayihbou.github.pentagramunam.fragment.RecyclerViewFragment;

public class PantallaPrincipal extends AppCompatActivity{


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contacto,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(this, ActivityContacto.class);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                Intent intent2 = new Intent(this, ActivityAcercaDe.class);
                startActivity(intent2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();


        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    //ArrayList Fragments
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new Perfil());

        return fragments;
    }
    //Para poner en orbita los Fragments, trabajando con las clase pageAdapter
    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        //Importar Iconos al View Pager de cada Tab
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog_profile);
    }

}
