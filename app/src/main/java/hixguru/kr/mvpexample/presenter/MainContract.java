package hixguru.kr.mvpexample.presenter;

import hixguru.kr.mvpexample.Model.User;

/**
 * Created by tta on 2017. 3. 27..
 */

public interface MainContract {

    interface Presenter {

        void loadData(String userName);

    }

    interface View {

        void showResult(User user);
    }
}
