package com.tutomas.javataxiseguimiento.service;

import com.tutomas.javataxiseguimiento.model.Coordenada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordenadaService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void enviarCoordenadasPeriodicamente(List<Coordenada> coordenadas) {
        for (Coordenada coordenada : coordenadas) {
            enviarCoordenada(coordenada);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void enviarCoordenada(Coordenada coordenada) {
        messagingTemplate.convertAndSend("/taxi/coordenada", coordenada);
        System.out.println("Coordenada enviada: " + coordenada);
    }
}
