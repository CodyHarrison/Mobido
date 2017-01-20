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
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String BASE_URL = "http://fhirtest.uhn.ca/baseDstu2/";
    TextView text_id_1;
    TextView text_id_2;
    TextView text_id_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        text_id_1 = (TextView) findViewById(R.id.text_id_1);
        text_id_2 = (TextView) findViewById(R.id.text_id_2);
        text_id_3 = (TextView) findViewById(R.id.text_id_3);

        Button ButtonObject = (Button) findViewById(R.id.RetrofitObject);

        ButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View VisibleObject = findViewById(R.id.RetrofitObject);
                VisibleObject.setVisibility(View.GONE);
                getRetrofitObject();
//                getRetrofitArray();
            }
        });

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
    }

    public void getRetrofitObject() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);

        /**
         * service.getPatientDetails aus der Klasse RetrofitObjectAPI
         **/
        Call<Patient> callPatient = service.getPatientDetails();
        callPatient.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                /**
                 * getResourceType und getBirthDate aus der Klasse Patient
                 * */
                text_id_1.setText("Resource Type: " + response.body().getResourceType());
                text_id_2.setText("ID: " + response.body().getId());
                /**
                 * response.body().getText().getStatus() -> Erst wird in der obersteb Ebene (Text) und dann in der unteren Ebene (Status) abgefragt.
                 * */
//                text_id_3.setText("Text: " + response.body().getText().getStatus());

                /**
                 * Erzeugung einer Variablen vom Typ patient und erhalten der Daten vom Server
                 * Erzeugung einer Liste vom Typ Name und speichern der Ergebnisse der Methode getName()
                 * */

                Patient patient = response.body();

                List<Name> names = patient.getName();

                for (Name name : names) {
                    List<String> nameHolder = name.getGiven();

                    if (nameHolder.size() > 1) {
                        String firstName = nameHolder.get(0);
                        String secondName = nameHolder.get(1);
                        text_id_3.setText("Vorname: " + firstName + " " + secondName);
                    }

                    System.out.println(name.getGiven());
                    System.out.println(name.getFamily());
                    System.out.println(name.getUse());
                }

            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                Log.d("sictik", "harbiden");
            }
        });

    }

    //TODO: Herausfinden wie man Arrays in Objects einzeln ansprechen kann
    //TODO: Eine Patientenliste mit Name und Vorname erstellen
    //TODO: Herausfinden in welchem Feld man Dokumentationen tätigt
    //TODO: Herausfinden wie man Dokumentation auf den Server schreibt
    public void getRetrofitArray() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);

        Call<List<Patient>> callPatient = service.getPatientDetails();
        callPatient.enqueue(new Callback<List<Patient>>() {
            @Override
            public void onResponse(Call<List<Patient>> call, Response<List<Patient>> response) {
                Patient patient = (Patient) response.body();

                List<Name> names = patient.getName();

                for (Name name : names) {
                    text_id_3.setText("Name: " + name.getUse());
                }

            }

            @Override
            public void onFailure(Call<List<Patient>> call, Throwable t) {
                text_id_3.setText("AMK");
            }
        });


    }

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
