package com.tutomas.javataxiseguimiento.controller;

import com.tutomas.javataxiseguimiento.inicial.CommandLineInit;
import com.tutomas.javataxiseguimiento.model.Coordenada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoordenadaController {

    @Autowired
    private CommandLineInit commandLineInit;

    @MessageMapping("/taxi")
    @SendTo("/taxi/coordenada")
    public Coordenada envio(Coordenada coordenada) {
        // tareas del socket
        return coordenada;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/start")
    @ResponseBody
    public String startSendingCoordinates() {
        try {
            commandLineInit.startSendingCoordinates();
            return "Iniciado envío de coordenadas.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al iniciar el envío de coordenadas.";
        }
    }
}
