package hixguru.kr.mvpexample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.textservice.TextInfo;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.GsonBuilder;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import hixguru.kr.mvpexample.Model.User;
import hixguru.kr.mvpexample.R;
import hixguru.kr.mvpexample.network.GithubApi;
import hixguru.kr.mvpexample.network.RetrofitCreator;
import hixguru.kr.mvpexample.presenter.MainContract;
import hixguru.kr.mvpexample.presenter.MainPresenterImpl;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscription;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.et_user_name) EditText etUserName;
    @BindView(R.id.tv_result) TextView tvResult;

    private MainContract.Presenter presenter;
    private Disposable editTextSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new MainPresenterImpl(this);

        editTextSub = RxTextView.textChanges(etUserName)
            .filter(new Predicate<CharSequence>() {
                @Override
                public boolean test(@NonNull CharSequence charSequence) throws Exception {
                    return charSequence.length() > 3;
                }
            })
            .subscribe(new Consumer<CharSequence>() {
                @Override
                public void accept(@NonNull CharSequence charSequence) throws Exception {
                    Log.e("tta", "accept: charSe" + charSequence);
                    presenter.loadData(charSequence.toString());
                }
            });
    }

    @Override
    public void showResult(User user) {
        tvResult.setText(new GsonBuilder().setPrettyPrinting().create().toJson(user));
    }

    @Override
    protected void onStop() {
        editTextSub.dispose();
    }
}
