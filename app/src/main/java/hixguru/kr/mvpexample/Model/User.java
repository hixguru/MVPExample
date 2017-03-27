package hixguru.kr.mvpexample.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tta on 2017. 3. 27..
 */

public class User {
    @SerializedName("login") private String login;
    private String id;
    @SerializedName("gravatarId") private String gravatar_id;
    private String url;
    @SerializedName("htmlUrl") private String html_url;
    private String name;

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getName() {
        return name;
    }
}
