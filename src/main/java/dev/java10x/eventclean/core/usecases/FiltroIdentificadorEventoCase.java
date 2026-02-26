package dev.java10x.eventclean.core.usecases;

import dev.java10x.eventclean.core.entities.Evento;

public interface FiltroIdentificadorEventoCase {
    Evento execute(String identificador);
}
