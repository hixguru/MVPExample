package hixguru.kr.mvpexample.presenter;

import android.util.Log;
import com.google.gson.GsonBuilder;
import hixguru.kr.mvpexample.Model.User;
import hixguru.kr.mvpexample.network.GithubApi;
import hixguru.kr.mvpexample.network.RetrofitCreator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by tta on 2017. 3. 27..
 */

public class MainPresenterImpl implements MainContract.Presenter {

    private static final String TAG = MainPresenterImpl.class.getSimpleName();
    private MainContract.View view;
    private Retrofit retrofit;

    public MainPresenterImpl(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData(String userName) {
        retrofit = RetrofitCreator.create();

        GithubApi api = retrofit.create(GithubApi.class);
        api.getUser(userName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(new Consumer<User>() {
                @Override
                public void accept(@NonNull User user) throws Exception {
                    Log.i(TAG, new GsonBuilder().setPrettyPrinting().create().toJson(user));
                    view.showResult(user);
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(@NonNull Throwable throwable) throws Exception {
                    Log.e(TAG, "accept: error : " + throwable.getMessage());
                }
            });
    }
}
