package ch.noseryoung.GhibliMovieReviews.security;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Credentials {

    private String userName;
    private String ps;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }
}
