CREATE TABLE IF NOT EXISTS Camera (
id         INTEGER                  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
version    INTEGER      NOT NULL    COMMENT 'Служебное поле hibernate',
name       VARCHAR(50)  NOT NULL    COMMENT 'Имя',
address_ip VARCHAR(50)  NOT NULL    COMMENT 'IP адрес камеры'
);
COMMENT ON TABLE Camera IS 'Информация о камерах';
