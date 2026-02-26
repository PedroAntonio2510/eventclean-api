package dev.java10x.eventclean.infra.mapper;

import dev.java10x.eventclean.core.entities.Evento;
import dev.java10x.eventclean.infra.persistence.evento.EventoEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EventoEntityMapper {

    public EventoEntity toEntity(Evento evento) {
        return EventoEntity.builder()
                .id(evento.id())
                .nome(evento.nome())
                .descricao(evento.descricao())
                .tipoEvento(evento.tipoEvento())
                .dataInicio(evento.dataInicio())
                .dataFim(evento.dataFim())
                .localEvento(evento.localEvento())
                .organizador(evento.organizador())
                .capacidade(evento.capacidade())
                .identificador(evento.identificador())
                .build();
    }

    public Evento toDomain(EventoEntity eventoEntity) {
        return new Evento(
                eventoEntity.getId(),
                eventoEntity.getNome(),
                eventoEntity.getDescricao(),
                eventoEntity.getIdentificador(),
                eventoEntity.getDataInicio(),
                eventoEntity.getDataFim(),
                eventoEntity.getLocalEvento(),
                eventoEntity.getOrganizador(),
                eventoEntity.getCapacidade(),
                eventoEntity.getTipoEvento()
        );
    }
}
