package com.wcsp.pe.mapper;

import com.wcsp.pe.dto.request.SolicitudDominioRequest;
import com.wcsp.pe.dto.request.SolicitudRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper
public interface SolicitudDominioMapper {

  SolicitudDominioMapper INSTANCE = Mappers.getMapper(SolicitudDominioMapper.class);

  default SolicitudDominioRequest map(SolicitudRequest request) {
    return SolicitudDominioRequest.builder()
            .dni(request.getDni())
            .nombres(request.getNombres())
            .apellidos(request.getApellidos())
            .correo(request.getCorreo())
            .celular(request.getCelular())
            .monto(Double.valueOf(request.getMonto()))
            .estado("ENVIADO")
            .fechaSolicitud(LocalDateTime.now())
            .build();
  }

}
