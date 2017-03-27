package hixguru.kr.mvpexample.network;

import hixguru.kr.mvpexample.Model.User;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by tta on 2017. 3. 27..
 */

public interface GithubApi {
    @GET("/users/{user}")
    Single<User> getUser(@Path("user") String user);
}
