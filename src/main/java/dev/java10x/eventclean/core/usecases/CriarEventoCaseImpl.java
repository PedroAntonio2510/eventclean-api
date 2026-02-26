package dev.java10x.eventclean.core.usecases;

import dev.java10x.eventclean.core.entities.Evento;
import dev.java10x.eventclean.core.gateway.EventoGateway;

public class CriarEventoCaseImpl implements CriarEventoCase{

    private final EventoGateway eventoGateway;

    public CriarEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        String identificador;
        do {
            identificador = eventoGateway.gerarIdentificador();
        } while (eventoGateway.existePorIdentificador(identificador));
        return eventoGateway.criarEvento(evento, identificador);
    }

}
