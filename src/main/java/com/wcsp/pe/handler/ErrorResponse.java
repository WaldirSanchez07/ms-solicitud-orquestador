package com.wcsp.pe.handler;

import java.util.Map;
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
class ErrorResponse {

  private Integer statusCode;
  private String message;
  private Map<String, String> errors;
}