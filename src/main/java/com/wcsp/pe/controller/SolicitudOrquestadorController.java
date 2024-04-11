package com.wcsp.pe.controller;

import com.wcsp.pe.dto.request.SolicitudRequest;
import com.wcsp.pe.dto.response.ResponseDto;
import com.wcsp.pe.mapper.SolicitudDominioMapper;
import com.wcsp.pe.webclient.SolicitudDominioClient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/solicitud-orquestador")
public class SolicitudOrquestadorController {

  private final SolicitudDominioClient solicitudDominioClient;

  @PostMapping(value = "save")
  public ResponseEntity<ResponseDto> saveSolicitud(@RequestBody @Valid SolicitudRequest solicitud) {
    try {
      solicitudDominioClient.saveSolicitud(SolicitudDominioMapper.INSTANCE.map(solicitud));
      return ResponseEntity.ok(ResponseDto.builder()
              .statusCode(HttpStatus.OK.value())
              .message("¡Solicitud de prestamo enviada!")
              .build());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
              .body(ResponseDto.builder()
                      .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                      .message("Error al guardar solicitud: " + e.getMessage())
                      .build());
    }
  }

  @GetMapping(value = "list")
  public ResponseEntity<ResponseDto> listSolicitudes() {
    try {
      return ResponseEntity.ok(solicitudDominioClient.listSolicitudes().getBody());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
              .body(ResponseDto.builder()
                      .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                      .message("Error al listar solicitudes: " + e.getMessage())
                      .build());
    }
  }

}
