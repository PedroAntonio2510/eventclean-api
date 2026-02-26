package dev.java10x.eventclean.infra.gateway;

import dev.java10x.eventclean.core.entities.Evento;
import dev.java10x.eventclean.core.gateway.EventoGateway;
import dev.java10x.eventclean.infra.mapper.EventoEntityMapper;
import dev.java10x.eventclean.infra.persistence.evento.EventoEntity;
import dev.java10x.eventclean.infra.persistence.evento.EventoRepository;
import dev.java10x.eventclean.infra.utils.GenerateStringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EventoRepositoryGateway implements EventoGateway {

    //Inversao de dependencia - "D" - solid - Dependency Inversion

    // Injecao de dependencia
    private final EventoRepository eventoRepository;
    private final GenerateStringUtils generateStringUtils;

    public EventoRepositoryGateway(EventoRepository eventoRepository, GenerateStringUtils generateStringUtils) {
        this.eventoRepository = eventoRepository;
        this.generateStringUtils = generateStringUtils;
    }

    @Override
    public Evento criarEvento(Evento evento, String identificador) {
        EventoEntity eventoNovo = EventoEntityMapper.toEntity(evento);
        eventoNovo.setIdentificador(identificador);
        EventoEntity eventoSalvo = eventoRepository.save(eventoNovo);
        return EventoEntityMapper.toDomain(eventoSalvo);
    }

    @Override
    public List<Evento> buscarEventos() {
        return eventoRepository.findAll().stream()
                .map(EventoEntityMapper::toDomain).toList();
    }

    @Override
    public Optional<Evento> buscarPorId(Long id) {
        Optional<EventoEntity> eventoEntity = eventoRepository.findById(id);
        return eventoEntity.map(EventoEntityMapper::toDomain);
    }

    @Override
    public boolean  existePorIdentificador(String identificador) {
        return eventoRepository.findAll().stream()
                .anyMatch(evento -> evento.getIdentificador().equalsIgnoreCase(identificador));
    }

    @Override
    public Optional<Evento> buscarPorIdentificador(String identificador) {
        Optional<EventoEntity> evento = eventoRepository.findByIdentificadorIgnoreCase(identificador);
        return evento.map(EventoEntityMapper::toDomain);
    }

    @Override
    public String gerarIdentificador() {
        return generateStringUtils.execute();
    }
}
