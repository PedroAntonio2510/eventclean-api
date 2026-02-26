package dev.java10x.eventclean.core.gateway;

import dev.java10x.eventclean.core.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {
    
    Evento criarEvento(Evento evento, String identificador);
    List<Evento> buscarEventos();
    Optional<Evento> buscarPorId(Long id);
    boolean existePorIdentificador(String identificador);
    Optional<Evento> buscarPorIdentificador(String identificador);
    String gerarIdentificador();
}
