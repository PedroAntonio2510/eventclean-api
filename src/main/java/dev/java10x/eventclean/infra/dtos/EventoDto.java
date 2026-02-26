package dev.java10x.eventclean.infra.dtos;

import dev.java10x.eventclean.core.enums.TipoEvento;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EventoDto(
        Long id,
        String nome,
        String description,
        String identificador,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String localEvento,
        String organizador,
        Integer capacidade,
        TipoEvento tipoEvento
) {
}
