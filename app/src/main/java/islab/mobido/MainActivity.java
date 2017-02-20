package islab.mobido;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String BASE_URL = "http://fhirtest.uhn.ca/baseDstu2/";
    public ArrayList<String> patientList = new ArrayList<>();
    ListView patientListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        patientListView = (ListView) findViewById(R.id.patientListView);
        ListAdapter pla = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                patientList);

        patientListView.setAdapter(pla);
        getRetrofitObject();


    }

    public void getRetrofitObject() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit client = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitObjectAPI service = client.create(RetrofitObjectAPI.class);


        /**
         * service.getPatientDetails aus der Klasse RetrofitObjectAPI
         **/
        Call<Patient> callPatient = service.getPatientDetailsById("4765");
        callPatient.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {

                /**
                 * Erzeugung einer Variablen vom Typ patient und erhalten der Daten vom Server
                 * Erzeugung einer Liste vom Typ Name und speichern der Ergebnisse der Methode getName()
                 * */

                Patient patient = response.body();

                List<Name> names = patient.getName();

                String firstName = null;
                String secondName;
                String fullName;

                for (Name name : names) {
                    List<String> nameHolder = name.getGiven();
                    String useHolder = name.getUse();


                    if (nameHolder.size() > 1) {
                        firstName = nameHolder.get(0);
                        secondName = nameHolder.get(1);
                        fullName = firstName + " " + secondName;
                        patientList.add(fullName);
                    }
                }
                ((BaseAdapter) patientListView.getAdapter()).notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                Log.d("sictik", "harbiden");
            }
        });
    }

    /**
     * public void getPatientListAdapter() {
     * <p>
     * ListAdapter pla = new ArrayAdapter<String>(
     * this,
     * android.R.layout.simple_list_item_1,
     * patientList);
     * <p>
     * ListView patientListView = (ListView) findViewById(R.id.patientListView);
     * patientListView.setAdapter(pla);
     * <p>
     * }
     */


    //TODO: Eine Patientenliste mit Name und Vorname erstellen
    //TODO: Herausfinden in welchem Feld man Dokumentationen tätigt
    //TODO: Herausfinden wie man Dokumentation auf den Server schreibt
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
