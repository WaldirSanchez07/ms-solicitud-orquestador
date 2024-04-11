package com.wcsp.pe.dto.request;

import jakarta.validation.constraints.*;
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
public class SolicitudRequest {

  @NotBlank(message = "{solicitud.dni.notBlank}")
  @Pattern(regexp = "^$|^\\d{8}$", message = "{solicitud.dni.pattern}")
  private String dni;

  @NotBlank(message = "{solicitud.nombres.notBlank}")
  @Pattern(regexp = "^$|^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$", message = "{solicitud.nombres.pattern}")
  private String nombres;

  @NotBlank(message = "{solicitud.apellidos.notBlank}")
  @Pattern(regexp = "^$|^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$", message = "{solicitud.apellidos.pattern}")
  private String apellidos;

  @NotBlank(message = "{solicitud.correo.notBlank}")
  @Email(message = "{solicitud.correo.pattern}")
  private String correo;

  @NotBlank(message = "{solicitud.celular.notBlank}")
  @Pattern(regexp = "^$|^9\\d{8}$", message = "{solicitud.celular.pattern}")
  private String celular;

  @NotBlank(message = "{solicitud.monto.notBlank}")
  @Min(value = 1000, message = "{solicitud.monto.min}")
  @Pattern(regexp = "^$|^(\\d+)?(\\.\\d{2})?$", message = "{solicitud.monto.pattern}")
  private String monto;

}
