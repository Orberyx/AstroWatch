CREATE DATABASE IF NOT EXISTS astrowatch;

USE astrowatch;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    senha_hash VARCHAR(255) NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE asteroide (
    id_nasa VARCHAR(30) PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    diametro_min_km DOUBLE,
    diametro_max_km DOUBLE,
    magnitude_absoluta DOUBLE,
    potencialmente_perigoso BOOLEAN NOT NULL,
    nasa_jpl_url VARCHAR(500),
    objeto_sentry BOOLEAN
);

CREATE TABLE aproximacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    asteroide_id VARCHAR(30) NOT NULL,
    data_aproximacao DATE NOT NULL,
    data_aproximacao_completa DATETIME,
    velocidade_kmh DOUBLE,
    distancia_km DOUBLE,
    distancia_lunar DOUBLE,
    corpo_orbitado VARCHAR(50),

    CONSTRAINT fk_aproximacao_asteroide
        FOREIGN KEY (asteroide_id)
        REFERENCES asteroide(id_nasa)
        ON DELETE CASCADE,

    UNIQUE (asteroide_id, data_aproximacao_completa)
);

CREATE TABLE favorito (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    asteroide_id VARCHAR(30) NOT NULL,
    favoritado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_favorito_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuario(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_favorito_asteroide
        FOREIGN KEY (asteroide_id)
        REFERENCES asteroide(id_nasa)
        ON DELETE CASCADE,

    UNIQUE (usuario_id, asteroide_id)
);
