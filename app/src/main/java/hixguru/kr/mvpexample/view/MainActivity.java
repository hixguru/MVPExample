package hixguru.kr.mvpexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.GsonBuilder;
import com.jakewharton.rxbinding2.widget.RxTextView;
import hixguru.kr.mvpexample.R;
import hixguru.kr.mvpexample.model.User;
import hixguru.kr.mvpexample.presenter.MainContract;
import hixguru.kr.mvpexample.presenter.MainPresenterImpl;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.et_user_name) EditText etUserName;
    @BindView(R.id.tv_result) TextView tvResult;

    private MainContract.Presenter presenter;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new MainPresenterImpl(this);

        disposable = RxTextView.textChanges(etUserName)
            .filter(charSequence -> charSequence.length() > 3)
            .subscribe(
                charSequence -> presenter.loadData(charSequence.toString()),
                Throwable::printStackTrace
            );
    }

    @Override
    public void showResult(User user) {
        tvResult.setText(new GsonBuilder().setPrettyPrinting().create().toJson(user));
    }

    @Override
    protected void onStop() {
        super.onStop();
        disposable.dispose();
    }
}
