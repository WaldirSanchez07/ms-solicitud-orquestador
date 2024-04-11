package com.wcsp.pe.webclient;

import com.wcsp.pe.dto.request.SolicitudDominioRequest;
import com.wcsp.pe.dto.response.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-solicitud-dominio", url = "http://localhost:8091/api/solicitud-dominio")
public interface SolicitudDominioClient {

  @PostMapping(value = "save")
  void saveSolicitud(@RequestBody SolicitudDominioRequest solicitud);

  @GetMapping(value = "list")
  ResponseEntity<ResponseDto> listSolicitudes();

}
