CREATE TABLE `tasks` (
`id`            BIGINT                AUTO_INCREMENT,
`subject`       VARCHAR(255)  NOT NULL,
`supporter`     VARCHAR(255) NOT NULL,
`content`      VARCHAR(255) NOT NULL,
`create_at`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_at`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
);