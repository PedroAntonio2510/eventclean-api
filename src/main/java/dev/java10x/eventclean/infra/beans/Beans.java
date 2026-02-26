package dev.java10x.eventclean.infra.beans;

import dev.java10x.eventclean.core.gateway.EventoGateway;
import dev.java10x.eventclean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public CriarEventoCase criarEventoCase(EventoGateway eventoGateway) {
        return new CriarEventoCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarEventoCase buscarEventoCase(EventoGateway eventoGateway) {
        return new BuscarEventoCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarEventoPorIdCase buscarEventoPorIdCase(EventoGateway eventoGateway) {
        return new BuscarEventoPorIdCaseImpl(eventoGateway);
    }

    @Bean
    public FiltroIdentificadorEventoCase filtroIdentificadorCase(EventoGateway eventoGateway) {
        return new FiltroIdentificadorCaseImpl(eventoGateway);
    }
}
