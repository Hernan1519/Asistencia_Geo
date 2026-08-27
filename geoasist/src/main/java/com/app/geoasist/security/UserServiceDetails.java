package com.app.geoasist.security;

import com.app.geoasist.model.Usuario;
import com.app.geoasist.repositorio.UsuarioReposity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceDetails implements UserDetailsService {
    private final UsuarioReposity usuarioReposity;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        return usuarioReposity.findByEmail(email)
                .map(CustomerUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("El Email no fue encontrado"));
    }
}
