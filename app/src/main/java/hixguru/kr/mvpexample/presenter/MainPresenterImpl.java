package hixguru.kr.mvpexample.presenter;

import hixguru.kr.mvpexample.network.GitHubApi;
import hixguru.kr.mvpexample.network.RetrofitCreator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by tta on 2017. 3. 27..
 */

public class MainPresenterImpl implements MainContract.Presenter {
    private MainContract.View view;

    public MainPresenterImpl(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData(String userName) {
        Retrofit retrofit = RetrofitCreator.create();

        GitHubApi api = retrofit.create(GitHubApi.class);
        api.getUser(userName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                user -> view.showResult(user),
                Throwable::printStackTrace
            );
    }
}
