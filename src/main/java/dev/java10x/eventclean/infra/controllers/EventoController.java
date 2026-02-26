package dev.java10x.eventclean.infra.controllers;

import dev.java10x.eventclean.core.entities.Evento;
import dev.java10x.eventclean.core.usecases.BuscarEventoCase;
import dev.java10x.eventclean.core.usecases.BuscarEventoPorIdCase;
import dev.java10x.eventclean.core.usecases.CriarEventoCase;
import dev.java10x.eventclean.core.usecases.FiltroIdentificadorEventoCase;
import dev.java10x.eventclean.infra.dtos.EventoDto;
import dev.java10x.eventclean.infra.mapper.EventoDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class EventoController {

    private final CriarEventoCase criarEventoCase;
    private final BuscarEventoCase buscarEventoCase;
    private final BuscarEventoPorIdCase buscarEventoPorIdCase;
    private final FiltroIdentificadorEventoCase filtroIdentificadorEventoCase;

    public EventoController(CriarEventoCase criarEventoCase, BuscarEventoCase buscarEventoCase, BuscarEventoPorIdCase buscarEventoPorIdCase, FiltroIdentificadorEventoCase filtroIdentificadorEventoCase) {
        this.criarEventoCase = criarEventoCase;
        this.buscarEventoCase = buscarEventoCase;
        this.buscarEventoPorIdCase = buscarEventoPorIdCase;
        this.filtroIdentificadorEventoCase = filtroIdentificadorEventoCase;
    }

    @PostMapping("criarEvento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto evento) {
        Evento novoEvento = criarEventoCase.execute(EventoDtoMapper.toDomain(evento));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Evento cadastrado com sucesso");
        response.put("Dados do evento: ", EventoDtoMapper.toDto(novoEvento));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("eventos")
    public ResponseEntity<List<EventoDto>> buscarEventos() {
        List<EventoDto> eventos = buscarEventoCase.execute().stream()
                .map(EventoDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("eventos/{id}")
    public ResponseEntity<EventoDto> buscarEvento(@PathVariable Long id) {
        Evento evento = buscarEventoPorIdCase.execute(id);
        return ResponseEntity.ok(EventoDtoMapper.toDto(evento));
    }

    @GetMapping("eventos/{identificador}/identificador")
    public ResponseEntity<EventoDto> buscarEventoPorIdentificador(@PathVariable String identificador) {
        Evento evento = filtroIdentificadorEventoCase.execute(identificador);
        return ResponseEntity.ok(EventoDtoMapper.toDto(evento));
    }
}
