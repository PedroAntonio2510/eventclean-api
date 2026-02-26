package dev.java10x.eventclean.infra.persistence.evento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
    boolean existsEventoEntityByIdentificadorIgnoreCase(String identificador);

    Optional<EventoEntity> findByIdentificadorIgnoreCase(String identificador);
}
