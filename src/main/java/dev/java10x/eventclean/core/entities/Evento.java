package dev.java10x.eventclean.core.entities;

import dev.java10x.eventclean.core.enums.TipoEvento;

import java.time.LocalDateTime;

public record Evento(
        Long id,
        String nome,
        String descricao,
        String identificador,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String localEvento,
        String organizador,
        Integer capacidade,
        TipoEvento tipoEvento
) {
}
