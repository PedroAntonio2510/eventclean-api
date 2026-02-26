package dev.java10x.eventclean.core.usecases;

import dev.java10x.eventclean.core.entities.Evento;
import dev.java10x.eventclean.core.gateway.EventoGateway;
import dev.java10x.eventclean.infra.exceptions.ResourceNotFoundException;

public class FiltroIdentificadorCaseImpl implements FiltroIdentificadorEventoCase {

    private final EventoGateway eventoGateway;

    public FiltroIdentificadorCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.buscarPorIdentificador(identificador)
                .orElseThrow(() -> new ResourceNotFoundException("Evento de identificador: " + identificador + " não encontrado"));
    }
}
