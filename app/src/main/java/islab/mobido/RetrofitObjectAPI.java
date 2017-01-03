package islab.mobido;

/**
 * Created by Harun on 25.12.16.
 */

import retrofit2.http.GET;
import retrofit2.Call;

public interface RetrofitObjectAPI {

    @GET("baseDstu2/Patient/128281")
    Call<Patient> getGender();

}
