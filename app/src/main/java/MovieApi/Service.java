package MovieApi;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
    @GET("movie/popular")
    Call<Response> getPopularMovies(@Query("pi_key") String apikey);

    @GET("movie/top_rated")
    Call<Response> getTopRatedMovies(@Query("pi_key") String apikey);
}

