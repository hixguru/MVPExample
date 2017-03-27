package hixguru.kr.mvpexample.presenter;

import android.text.TextUtils;

/**
 * Created by tta on 2017. 3. 27..
 */

public class LoginPresenterImpl implements LoginContract.Presenter {

    private LoginContract.View view;

    public LoginPresenterImpl(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void onClickLoginBtn(String email, String password) {
        boolean isInputEmpty = TextUtils.isEmpty(email) || TextUtils.isEmpty(password);
        boolean isValidEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

        if (isInputEmpty) {
            view.showEmptyInput();
            return;
        }

        if (!isValidEmail) {
            view.showValidationFailed();
            return;
        }

        view.startMainActivity();
    }
}
