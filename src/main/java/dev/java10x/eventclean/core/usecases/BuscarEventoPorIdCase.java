package dev.java10x.eventclean.core.usecases;

import dev.java10x.eventclean.core.entities.Evento;

import java.util.Optional;

public interface BuscarEventoPorIdCase {
    Evento execute(Long id);
}
