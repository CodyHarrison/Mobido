package islab.mobido;

/**
 * Created by Harun on 25.12.16.
 */

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitObjectAPI {

    //In den unteren GET Methoden wird ein spezifischer Patient 3840 angegeben.
    //In Zukunft sollen die Patienten vom Benutzer wählbar sein, dh. variabel.

    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    /**
     * Retrofit get annotation mit der URL zum Patienten
     * und der Methode, mit der wir Patienteninformationen erhalten wollen.
     */

    @GET("Patient/4765?_format=json")
    Call<Patient> getPatientDetails();


//    @GET("Patient/4765?_format=json")
//    Call<>

    /*@GET("Patient/{id}?_pretty=true&_format=html/json")
    Call<List<Name>> getPatientName(@Path("id") int groupId);*/

    /**

     @GET("baseDstu2/Patient/3840?_pretty=true&_format=json") Call<Patient> getResourceType();

     @GET("baseDstu2/Patient/3840?_pretty=true&_format=json") Call<Patient> getName();

     @GET("baseDstu2/Patient/3840?_pretty=true&_format=json") Call<Patient> getTelecom();

     @GET("baseDstu2/Patient/3840?_pretty=true&_format=json")
    Call<Patient> getGender();

     */
}
