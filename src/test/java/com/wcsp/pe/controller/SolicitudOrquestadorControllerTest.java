package com.wcsp.pe.controller;

import com.wcsp.pe.dto.response.ResponseDto;
import com.wcsp.pe.webclient.SolicitudDominioClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static com.wcsp.pe.utils.SolicitudTestUtil.generateSolicitud;
import static com.wcsp.pe.utils.SolicitudTestUtil.generateResponseSolicitudes;

@ExtendWith(MockitoExtension.class)
public class SolicitudOrquestadorControllerTest {

  @InjectMocks
  private SolicitudOrquestadorController solicitudController;

  @Mock
  private SolicitudDominioClient solicitudDominioClient;

  @BeforeEach
  public void init() {
    solicitudController = new SolicitudOrquestadorController(solicitudDominioClient);
  }

  @Test
  public void testSaveSolicitudSuccess() throws Exception {
    doNothing().when(solicitudDominioClient).saveSolicitud(any());
    ResponseEntity<ResponseDto> response = solicitudController.saveSolicitud(generateSolicitud());

    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void testSaveSolicitudFail() {
    doThrow(new RuntimeException("Error")).when(solicitudDominioClient).saveSolicitud(any());
    ResponseEntity<ResponseDto> response = solicitudController.saveSolicitud(generateSolicitud());

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
  }

  @Test
  public void testListSolicitudSuccess() throws Exception {
    doReturn(generateResponseSolicitudes()).when(solicitudDominioClient).listSolicitudes();
    ResponseEntity<ResponseDto> response = solicitudController.listSolicitudes();

    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void testListSolicitudFail() {
    doThrow(new RuntimeException("Error")).when(solicitudDominioClient).listSolicitudes();
    ResponseEntity<ResponseDto> response = solicitudController.listSolicitudes();

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
  }

}
