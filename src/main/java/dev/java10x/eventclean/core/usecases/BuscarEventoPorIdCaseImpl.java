package dev.java10x.eventclean.core.usecases;

import dev.java10x.eventclean.core.entities.Evento;
import dev.java10x.eventclean.core.gateway.EventoGateway;
import dev.java10x.eventclean.infra.exceptions.ResourceNotFoundException;

import java.util.NoSuchElementException;

public class BuscarEventoPorIdCaseImpl implements BuscarEventoPorIdCase {

    private final EventoGateway eventoGateway;

    public BuscarEventoPorIdCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Long id) {
        return eventoGateway.buscarPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Evento de id: %s não encontrado", id)));
    }
}
