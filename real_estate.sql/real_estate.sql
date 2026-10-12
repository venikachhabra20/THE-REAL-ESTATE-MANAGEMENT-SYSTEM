CREATE DATABASE real_estate_systemdb;
use real_estate_systemdb;

    CREATE TABLE USERS (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(15),
    role ENUM('USER', 'ADMIN') DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
  CREATE TABLE  AGENTS (
    agent_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15),
    experience INT DEFAULT 0);
CREATE TABLE  properties (
    property_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    description VARCHAR(500),
    location VARCHAR(150) NOT NULL,
    price DECIMAL(15,2) NOT NULL,
    property_type ENUM('APARTMENT', 'HOUSE', 'VILLA', 'PLOT', 'COMMERCIAL') NOT NULL,
    status ENUM('AVAILABLE', 'SOLD', 'RENTED') DEFAULT 'AVAILABLE',
    bedrooms INT DEFAULT 0,
    bathrooms INT DEFAULT 0,
    area_sqft INT,
    agent_id INT,

    FOREIGN KEY (agent_id)
        REFERENCES agents(agent_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);
CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    property_id INT NOT NULL,
    user_id INT NOT NULL,
    transaction_type ENUM('BUY', 'RENT') NOT NULL,
    transaction_date DATE NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    status ENUM('PENDING', 'COMPLETED', 'CANCELLED') DEFAULT 'PENDING',

    FOREIGN KEY (property_id)
        REFERENCES properties(property_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
CREATE TABLE property_images (
    image_id INT PRIMARY KEY AUTO_INCREMENT,
    property_id INT NOT NULL,
    image_url VARCHAR(500) NOT NULL,

    FOREIGN KEY (property_id)
        REFERENCES properties(property_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
CREATE TABLE  favorites (
    favorite_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    property_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    UNIQUE(user_id, property_id),

    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE,

    FOREIGN KEY (property_id)
        REFERENCES properties(property_id)
        ON DELETE CASCADE
);
INSERT INTO USERS (name, email, password, phone, role)
VALUES
('Venika', 'venika@gmail.com', '12345', '9876543210', 'USER'),
('Ananya', 'ananya@gmail.com', '123456', '9876543211', 'USER'),
('Priyanshi', 'priyanshi@gmail.com', '123456', '9876543212', 'USER'),
('Admin', 'admin@gmail.com', 'admin123', '9876500000', 'ADMIN');
INSERT INTO AGENTS (name, email, phone, experience)
VALUES
('Rahul Sharma', 'rahul@gmail.com', '9876512345', 5),
('Priya Singh', 'priya@gmail.com', '9876598765', 3),
('Amit Verma', 'amit@gmail.com', '9876587654', 7);
INSERT INTO properties
(title, description, location, price, property_type, status,
 bedrooms, bathrooms, area_sqft, agent_id)
VALUES

(
    'Modern 2BHK Apartment',
    'Spacious 2BHK apartment with modern facilities',
    'Greater Noida',
    4500000,
    'APARTMENT',
    'AVAILABLE',
    2,
    2,
    1200,
    1
),

(
    'Luxury Family Villa',
    'Beautiful villa with parking and garden',
    'Noida',
    8500000,
    'VILLA',
    'AVAILABLE',
    4,
    3,
    2500,
    2
),

(
    'Commercial Office Space',
    'Fully furnished office space',
    'Greater Noida',
    6000000,
    'COMMERCIAL',
    'AVAILABLE',
    0,
    2,
    1800,
    1
),

(
    'Residential Plot',
    'Well located residential plot',
    'Yamuna Expressway',
    3000000,
    'PLOT',
    'AVAILABLE',
    0,
    0,
    1500,
    3
),

(
    '3BHK Family House',
    'Independent house suitable for families',
    'Noida Extension',
    6500000,
    'HOUSE',
    'AVAILABLE',
    3,
    3,
    1800,
    2
);
INSERT INTO property_images (property_id, image_url)
VALUES
(1, 'images/apartment.jpg'),
(2, 'images/villa.jpg'),
(3, 'images/office.jpg'),
(4, 'images/plot.jpg'),
(5, 'images/house.jpg');
INSERT INTO favorites (user_id, property_id)
VALUES
(1, 1),
(1, 2),
(2, 3);
INSERT INTO transactions
(property_id, user_id, transaction_type, transaction_date, amount, status)
VALUES
(1, 1, 'BUY', CURDATE(), 4500000, 'PENDING');
CREATE INDEX idx_property_location
ON properties(location);

CREATE INDEX idx_property_type
ON properties(property_type);

CREATE INDEX idx_property_status
ON properties(status);

CREATE INDEX idx_property_price
ON properties(price);
CREATE OR REPLACE VIEW available_properties AS
SELECT
    p.property_id,
    p.title,
    p.location,
    p.price,
    p.property_type,
    p.bedrooms,
    p.bathrooms,
    p.area_sqft,
    a.name AS agent_name,
    a.phone AS agent_phone
FROM properties p
LEFT JOIN agents a
    ON p.agent_id = a.agent_id
WHERE p.status = 'AVAILABLE';
CREATE OR REPLACE VIEW property_transactions AS
SELECT
    t.transaction_id,
    u.name AS customer_name,
    u.email AS customer_email,
    p.title AS property_name,
    p.location,
    t.transaction_type,
    t.amount,
    t.transaction_date,
    t.status
FROM transactions t
JOIN users u
    ON t.user_id = u.user_id
JOIN properties p
    ON t.property_id = p.property_id;
    





