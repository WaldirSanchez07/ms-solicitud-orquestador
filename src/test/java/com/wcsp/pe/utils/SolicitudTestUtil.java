package com.wcsp.pe.utils;

import com.wcsp.pe.dto.request.SolicitudRequest;
import com.wcsp.pe.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class SolicitudTestUtil {

  public static SolicitudRequest generateSolicitud() {
    return SolicitudRequest.builder()
            .dni("80706021")
            .nombres("Juan")
            .apellidos("Soto Castro")
            .correo("jsoto@gmail.com")
            .celular("987654321")
            .monto("15000.00")
            .build();
  }

  public static ResponseEntity<ResponseDto> generateResponseSolicitudes() {
    return ResponseEntity.ok(ResponseDto.builder()
            .statusCode(HttpStatus.OK.value())
            .data(new ArrayList<>())
            .build());
  }

}
