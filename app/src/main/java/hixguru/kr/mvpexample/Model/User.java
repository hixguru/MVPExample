package hixguru.kr.mvpexample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tta on 2017. 3. 27..
 */

public class User {
    @SerializedName("login") private String login;
    @SerializedName("gravatar_id") private String gravatarId;
    @SerializedName("html_url") private String htmlUrl;
    private String id;
    private String url;

    public String getLogin() {
        return login;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
