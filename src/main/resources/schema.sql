DROP TABLE IF EXISTS authorities cascade;
DROP TABLE IF EXISTS users cascade;

CREATE TABLE users (
                       username VARCHAR(50)  NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       enabled  BOOLEAN      NOT NULL DEFAULT True,
                       PRIMARY KEY (username)
);

CREATE TABLE authorities (
                             username  VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             FOREIGN KEY (username) REFERENCES users (username)
);
