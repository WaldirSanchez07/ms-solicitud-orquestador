package com.wcsp.pe.dto.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudDominioRequest {

  private String dni;
  private String nombres;
  private String apellidos;
  private String correo;
  private String celular;
  private Double monto;
  private String estado;
  private LocalDateTime fechaSolicitud;

}
