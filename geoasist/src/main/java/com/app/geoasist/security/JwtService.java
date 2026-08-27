package com.app.geoasist.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiracion;

    public String generateToken(Authentication authentication){
        CustomerUserDetails usuarioDetail= (CustomerUserDetails) authentication.getPrincipal();

        Map<String, Object> extraClaim= new HashMap<>();

        extraClaim.put("id",usuarioDetail.usuario().getIdUsuario());

        var roles= usuarioDetail.getAuthorities()
                .stream().map(auth -> auth.getAuthority())
                .toList();

        extraClaim.put("role",roles);
        long actual= System.currentTimeMillis();
        Date fechaExpiracion= new Date(actual+expiracion);
        return Jwts.builder()
                .claims(extraClaim)
                .subject(authentication.getName())
                .issuedAt(new Date(actual))
                .expiration(fechaExpiracion)
                .signWith(obtenerClaveFirma())
                .compact();
    }

    private SecretKey obtenerClaveFirma() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
