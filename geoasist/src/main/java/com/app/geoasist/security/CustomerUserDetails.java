package com.app.geoasist.security;

import com.app.geoasist.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public record CustomerUserDetails (Usuario usuario)implements UserDetails {
    @Override
    public String getUsername(){
        return usuario.getEmail();
    }
    @Override
    public  String getPassword(){
        return usuario.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+usuario.getRol().getTipoRol()));
    }
}
