package dev.java10x.eventclean.infra.persistence.evento;

import dev.java10x.eventclean.core.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "Eventos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @Column(unique = true, nullable = false)
    private String identificador;
    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private String localEvento;
    private String organizador;
    private Integer capacidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private TipoEvento tipoEvento;
}
