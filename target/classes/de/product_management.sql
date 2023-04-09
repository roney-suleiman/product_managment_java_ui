-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 24. Nov 2022 um 10:56
-- Server-Version: 10.4.25-MariaDB
-- PHP-Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `product_management`
--
CREATE DATABASE IF NOT EXISTS `product_management` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `product_management`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `products`
--

CREATE TABLE `products` (
  `pk_id` int(11) NOT NULL,
  `name` text NOT NULL,
  `weight` double NOT NULL,
  `buyPrice` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `tax` double NOT NULL,
  `shippingPrice` double NOT NULL,
  `sellPrice` double NOT NULL,
  `expireDate` date NOT NULL,
  `validity` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `products`
--

INSERT INTO `products` (`pk_id`, `name`, `weight`, `buyPrice`, `quantity`, `tax`, `shippingPrice`, `sellPrice`, `expireDate`, `validity`) VALUES
(42, 'Pizza soße', 0.9, 1, 0, 0.19, 9, 10.44, '2022-11-01', 'Expired'),
(43, 'pizza', 3, 7, 44, 1.33, 3, 13.08, '2020-11-12', 'Expired'),
(44, 'Jugort', 3, 3, 3, 0.57, 3, 7.32, '2025-11-01', 'UnExpired'),
(45, 'Tonfisch', 0.25, 1, 210, 0.19, 0.2, 1.64, '2024-11-09', 'UnExpired'),
(46, 'brot', 0.2, 0.45, 42, 0.0855, 0.1, 0.748, '2022-11-22', 'Expired'),
(47, 'Reis', 10, 9.5, 50, 1.805, 1, 14.68, '2025-11-21', 'UnExpired'),
(48, 'Eier', 0.8, 1.2, 22, 0.228, 0.1, 1.828, '2022-11-22', 'Expired'),
(49, 'olivenöl', 0.8, 1.9, 75, 0.361, 0.2, 2.936, '2025-11-12', 'UnExpired'),
(50, 'Wein', 0.6, 3, 50, 0.57, 0.3, 4.62, '2024-11-30', 'UnExpired'),
(51, 'Mayonnaise', 0.4, 0.7, 136, 0.13299999999999998, 0.1, 1.108, '2025-11-01', 'UnExpired'),
(52, 'Ketchup', 0.3, 0.5, 12, 0.095, 0.1, 0.82, '2022-11-18', 'Expired'),
(53, 'Milch', 0.7, 1.1, 122, 0.20900000000000002, 0.2, 1.784, '2024-11-24', 'UnExpired'),
(54, 'Mehl', 1.5, 2.1, 55, 0.39899999999999997, 0.8, 3.824, '2023-11-14', 'UnExpired');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`pk_id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `products`
--
ALTER TABLE `products`
  MODIFY `pk_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
