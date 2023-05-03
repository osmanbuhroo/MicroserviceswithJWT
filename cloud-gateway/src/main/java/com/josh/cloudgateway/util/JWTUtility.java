package com.josh.cloudgateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class JWTUtility  {

    @Value("${jwt.secret}")
    private String secretKey;

    public Claims getClaimsFromToken(final String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    public void validateToken(final String token) {
        Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
    }


}