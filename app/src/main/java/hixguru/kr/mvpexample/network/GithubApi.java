package hixguru.kr.mvpexample.network;

import hixguru.kr.mvpexample.model.User;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by tta on 2017. 3. 27..
 */

public interface GitHubApi {

    @GET("/users/{user}")
    Single<User> getUser(@Path("user") String user);

}
