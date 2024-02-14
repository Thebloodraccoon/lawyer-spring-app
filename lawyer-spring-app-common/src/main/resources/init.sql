CREATE TABLE t_client (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(64) NOT NULL,
                          phone_number VARCHAR(64) NOT NULL,
                          email VARCHAR(64)
);


CREATE TABLE t_lawyer (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(64) NOT NULL,
                          phone_number VARCHAR(64)  NOT NULL,
                          email VARCHAR(64),
                          specialization VARCHAR(64),
                          consultation_title VARCHAR(64)
);


CREATE TABLE t_service (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           type VARCHAR(64) NOT NULL,
                           name VARCHAR(64),
                           date DATE,
                           cost DOUBLE,
                           client_id INT NOT NULL,
                           lawyer_id INT NOT NULL,
                           FOREIGN KEY (client_id) REFERENCES t_client(id),
                           FOREIGN KEY (lawyer_id) REFERENCES t_lawyer(id)
);


CREATE TABLE t_address (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           country VARCHAR(64),
                           state VARCHAR(64),
                           place VARCHAR(64),
                           street VARCHAR(64),
                           house_num VARCHAR(64),
                           apartment VARCHAR(64),
                           client_id INT UNIQUE,
                           FOREIGN KEY (client_id) REFERENCES t_client(id)
);


-- Inserts into database
INSERT INTO t_lawyer (name, phone_number, email, specialization, consultation_title)
VALUES
    ('John Doe', '123-456-7890', 'john.doe@example.com', 'Corporate Law', 'Legal Consultation'),
    ('Jane Smith', '234-567-8901', 'jane.smith@example.com', 'Criminal Law', 'Legal Advice'),
    ('Alice Johnson', '345-678-9012', 'alice.johnson@example.com', 'Family Law', 'Legal Support');


INSERT INTO t_client (name, phone_number, email)
VALUES
    ('Client A', '987-654-3210', 'clientA@example.com'),
    ('Client B', '876-543-2109', 'clientB@example.com'),
    ('Client C', '765-432-1098', 'clientC@example.com');


INSERT INTO t_service (type, name, date, cost, client_id, lawyer_id)
VALUES
    ('Consultation', 'Service 1', '2024-02-14', 100.00, 1, 1),
    ('Legal Advice', 'Service 2', '2024-02-14', 150.00, 2, 2),
    ('Legal Support', 'Service 3', '2024-02-14', 200.00, 3, 3);


INSERT INTO t_address (country, state, place, street, house_num, apartment, client_id)
VALUES
    ('USA', 'California', 'Los Angeles', 'Main Street', '123', 'Apt 1', 1),
    ('UK', 'England', 'London', 'Oxford Street', '456', 'Flat 2', 2),
    ('France', 'Paris', 'Paris', 'Champs-Élysées', '789', 'Apartment 3', 3);