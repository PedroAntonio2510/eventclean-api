-- V1_criar_tabela_evento.sql
-- CREATE TYPE tipoEvento AS ENUM ('WORKSHOP', 'PALESTRA', 'MUSICA', 'SEMINARIO');

CREATE TABLE Eventos(
  id serial primary key,
  nome varchar(255) not null,
  descricao text,
  identificador varchar(255) not null unique,
  data_inicio timestamp NOT NULL,
  data_fim timestamp NOT NULL,
  local_evento varchar(255) NOT NULL,
  organizador varchar(255),
  capacidade integer,
  tipo_evento VARCHAR(50) NOT NULL
);