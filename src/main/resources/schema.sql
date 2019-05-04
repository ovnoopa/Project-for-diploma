CREATE TABLE IF NOT EXISTS Camera (
id         INTEGER                  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
version    INTEGER      NOT NULL    COMMENT 'Служебное поле hibernate',
name       VARCHAR(50)  NOT NULL    COMMENT 'Имя'
);
COMMENT ON TABLE Camere IS 'Информация о камерах';

CREATE TABLE IF NOT EXISTS Ping (
id         INTEGER                  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
version    INTEGER      NOT NULL    COMMENT 'Служебное поле hibernate',
camera_id  INTEGER      NOT NULL    COMMENT 'Внешний ключ',
value      INTEGER      NOT NULL    COMMENT 'значение'

);
COMMENT ON TABLE Ping IS 'Информация о пингу';

create INDEX I_cameera_id ON Ping (camera_id);

alter table Ping FOREIGN KEY (camera_id) REFERENCES Camera(id);