-- MAUVAISE PRATIQUE : SQL avec injection potentielle
INSERT INTO student (id, name, age, email, password)
VALUES (1, 'John Doe', 20, 'john@school.com', 'password123');

INSERT INTO student (id, name, age, email, password)
VALUES (2, 'Jane Smith', 22, 'jane@school.com', '123456');

-- MAUVAISE PRATIQUE : Données sensibles en clair
INSERT INTO teacher (id, name, subject, salary, secret_key)
VALUES (1, 'Mr. Smith', 'Mathematics', 50000, 'SECRET-123-ABC');