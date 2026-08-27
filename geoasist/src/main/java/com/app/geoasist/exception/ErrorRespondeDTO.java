package com.app.geoasist.exception;

import java.time.LocalDateTime;

public record ErrorRespondeDTO(int codigo,
                               String mensaje,
                               LocalDateTime time) {
    public ErrorRespondeDTO(int codigo,String mensaje){
        this(codigo,mensaje,LocalDateTime.now());
    }

}
