package islab.mobido;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.GET;

/**
 * Created by Harun on 17.01.2017.
 */

public interface RetrofitArrayAPI {

    @GET("Patient/4765?_format=json")
    Call<List<Patient>> getPatientDetails();


}
