package dev.java10x.eventclean.core.usecases;

import dev.java10x.eventclean.core.entities.Evento;

import java.util.List;

public interface BuscarEventoCase {
    List<Evento> execute();
}
