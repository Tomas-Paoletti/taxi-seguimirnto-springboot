package com.tutomas.javataxiseguimiento.controller;

import com.tutomas.javataxiseguimiento.model.Coordenada;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taxiapp")
public class TaxiController {

    private final SimpMessagingTemplate template;

    public TaxiController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @PostMapping("/send-coordenada")
    public void sendCoordenada(
            @RequestBody Coordenada coordenada
    ) {
        // tareas rest controller
        this.template.convertAndSend(
                "/taxi/coordenada",
                coordenada);
    }
}
