package dev.java10x.eventclean.infra.mapper;

import dev.java10x.eventclean.core.entities.Evento;
import dev.java10x.eventclean.infra.dtos.EventoDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EventoDtoMapper {

    public static Evento toDomain(EventoDto dto) {
        return new Evento(dto.id(),
                dto.nome(),
                dto.description(),
                dto.identificador(),
                dto.dataInicio(),
                dto.dataFim(),
                dto.localEvento(),
                dto.organizador(),
                dto.capacidade(),
                dto.tipoEvento());

    }

    public static EventoDto toDto(Evento entity) {
        return EventoDto.builder()
                .id(entity.id())
                .nome(entity.nome())
                .description(entity.descricao())
                .identificador(entity.identificador())
                .dataInicio(entity.dataInicio())
                .dataFim(entity.dataFim())
                .localEvento(entity.localEvento())
                .organizador(entity.organizador())
                .capacidade(entity.capacidade())
                .tipoEvento(entity.tipoEvento())
                .build();
    }
}
