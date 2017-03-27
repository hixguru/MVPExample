package hixguru.kr.mvpexample.presenter;

/**
 * Created by tta on 2017. 3. 27..
 */

public interface LoginContract {

    interface Presenter {

        void onClickLoginBtn(String email, String password);

    }

    interface View {

        void showEmptyInput();

        void showValidationFailed();

        void startMainActivity();
    }
}
