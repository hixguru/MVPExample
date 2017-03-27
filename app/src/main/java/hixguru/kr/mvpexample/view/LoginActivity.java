package hixguru.kr.mvpexample.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hixguru.kr.mvpexample.R;
import hixguru.kr.mvpexample.presenter.LoginContract;
import hixguru.kr.mvpexample.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.et_email) EditText etEmail;
    @BindView(R.id.et_password) EditText etPassword;

    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        presenter = new LoginPresenterImpl(this);
    }

    @OnClick(R.id.btn_login) void login() {
        presenter.onClickLoginBtn(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void showEmptyInput() {
        Toast.makeText(this, "이메일 또는 패스워드를 입력해주세요.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showValidationFailed() {
        Toast.makeText(this, "유효한 이메일 형식이 아닙니다.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
