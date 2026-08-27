package com.app.geoasist.security;

import com.app.geoasist.dto.LoginUsuarioDTO;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtServices;

    public String login (LoginUsuarioDTO request){
        UsernamePasswordAuthenticationToken auth= new UsernamePasswordAuthenticationToken(
                request.email(),
                request.password()
        );
        Authentication authentication=  authenticationManager.authenticate(auth);

            return jwtServices.generateToken(authentication);

    }
}
