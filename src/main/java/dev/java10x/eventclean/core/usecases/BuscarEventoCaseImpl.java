package dev.java10x.eventclean.core.usecases;

import dev.java10x.eventclean.core.entities.Evento;
import dev.java10x.eventclean.core.gateway.EventoGateway;

import java.util.List;

public class BuscarEventoCaseImpl implements BuscarEventoCase {

    private final EventoGateway eventoGateway;

    public BuscarEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute() {
        return eventoGateway.buscarEventos();
    }
}
