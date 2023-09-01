package ch.noseryoung.GhibliMovieReviews.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jwt")
public class JwtProperties {

    private long expirationMillis;
    private String issuer;
    private String secret;
    private String headerString;

    public JwtProperties() {
    }

    public JwtProperties(long expirationMillis, String issuer, String secret, String headerString) {
        this.expirationMillis = expirationMillis;
        this.issuer = issuer;
        this.secret = secret;
        this.headerString = headerString;
    }

    public long getExpirationMillis() {
        return expirationMillis;
    }

    public JwtProperties setExpirationMillis(long expirationMillis) {
        this.expirationMillis = expirationMillis;
        return this;
    }

    public String getIssuer() {
        return issuer;
    }

    public JwtProperties setIssuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public JwtProperties setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String getHeaderString() {
        return headerString;
    }

    public void setHeaderString(String headerString) {
        this.headerString = headerString;
    }
}
