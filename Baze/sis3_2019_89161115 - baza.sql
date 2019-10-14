-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 12, 2019 at 08:24 PM
-- Server version: 5.7.26-0ubuntu0.16.04.1
-- PHP Version: 7.0.33-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sis3_2019_89161115`
--

-- --------------------------------------------------------

--
-- Table structure for table `Koledar`
--

CREATE TABLE `Koledar` (
  `KO_id` int(255) NOT NULL,
  `Time` time NOT NULL,
  `Datum` date NOT NULL,
  `Year` year(4) NOT NULL,
  `Mesec` varchar(255) NOT NULL,
  `Teden` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Komentar`
--

CREATE TABLE `Komentar` (
  `K_id` int(255) NOT NULL,
  `Opis` text NOT NULL,
  `Datum` date NOT NULL,
  `Cas` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Lokacija`
--

CREATE TABLE `Lokacija` (
  `L_id` int(255) NOT NULL,
  `Naslov` varchar(255) NOT NULL,
  `Mesto` varchar(255) NOT NULL,
  `Država` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Ocena`
--

CREATE TABLE `Ocena` (
  `O_id` int(255) NOT NULL,
  `povp_U` int(255) NOT NULL,
  `pos_O_stranke` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Stranka`
--

CREATE TABLE `Stranka` (
  `S_id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Uporabnik`
--

CREATE TABLE `Uporabnik` (
  `U_id` int(255) NOT NULL,
  `Ime` varchar(255) NOT NULL,
  `Priimek` varchar(255) NOT NULL,
  `e_mail` varchar(255) NOT NULL,
  `Telefonska` int(255) NOT NULL,
  `Geslo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Žival`
--

CREATE TABLE `Žival` (
  `Z_id` int(255) NOT NULL,
  `Velikost` int(255) NOT NULL,
  `Pasma` varchar(255) NOT NULL,
  `Teza` int(255) NOT NULL,
  `Vrsta` varchar(255) NOT NULL,
  `Z_O` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Koledar`
--
ALTER TABLE `Koledar`
  ADD PRIMARY KEY (`KO_id`),
  ADD KEY `Time` (`Time`),
  ADD KEY `Datum` (`Datum`),
  ADD KEY `Year` (`Year`),
  ADD KEY `Mesec` (`Mesec`),
  ADD KEY `Teden` (`Teden`),
  ADD KEY `KO_id` (`KO_id`);

--
-- Indexes for table `Komentar`
--
ALTER TABLE `Komentar`
  ADD PRIMARY KEY (`K_id`),
  ADD KEY `Datum` (`Datum`),
  ADD KEY `Cas` (`Cas`),
  ADD KEY `K_id` (`K_id`);

--
-- Indexes for table `Lokacija`
--
ALTER TABLE `Lokacija`
  ADD PRIMARY KEY (`L_id`),
  ADD KEY `Naslov` (`Naslov`),
  ADD KEY `Mesto` (`Mesto`),
  ADD KEY `Država` (`Država`),
  ADD KEY `L_id` (`L_id`);

--
-- Indexes for table `Ocena`
--
ALTER TABLE `Ocena`
  ADD PRIMARY KEY (`O_id`),
  ADD KEY `O_id` (`O_id`),
  ADD KEY `povp_U` (`povp_U`),
  ADD KEY `pos_O_stranke` (`pos_O_stranke`);

--
-- Indexes for table `Stranka`
--
ALTER TABLE `Stranka`
  ADD PRIMARY KEY (`S_id`),
  ADD KEY `S_id` (`S_id`);

--
-- Indexes for table `Uporabnik`
--
ALTER TABLE `Uporabnik`
  ADD PRIMARY KEY (`U_id`),
  ADD KEY `Ime` (`Ime`),
  ADD KEY `Priimek` (`Priimek`),
  ADD KEY `e_mail` (`e_mail`),
  ADD KEY `Telefonska` (`Telefonska`),
  ADD KEY `Geslo` (`Geslo`);

--
-- Indexes for table `Žival`
--
ALTER TABLE `Žival`
  ADD PRIMARY KEY (`Z_id`),
  ADD KEY `Velikost` (`Velikost`),
  ADD KEY `Pasma` (`Pasma`),
  ADD KEY `Teza` (`Teza`),
  ADD KEY `Vrsta` (`Vrsta`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Koledar`
--
ALTER TABLE `Koledar`
  ADD CONSTRAINT `Koledar_ibfk_1` FOREIGN KEY (`KO_id`) REFERENCES `Stranka` (`S_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Lokacija`
--
ALTER TABLE `Lokacija`
  ADD CONSTRAINT `Lokacija_ibfk_1` FOREIGN KEY (`L_id`) REFERENCES `Stranka` (`S_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Ocena`
--
ALTER TABLE `Ocena`
  ADD CONSTRAINT `Ocena_ibfk_1` FOREIGN KEY (`povp_U`) REFERENCES `Uporabnik` (`U_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Stranka`
--
ALTER TABLE `Stranka`
  ADD CONSTRAINT `Stranka_ibfk_1` FOREIGN KEY (`S_id`) REFERENCES `Ocena` (`pos_O_stranke`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Stranka_ibfk_2` FOREIGN KEY (`S_id`) REFERENCES `Komentar` (`K_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Stranka_ibfk_3` FOREIGN KEY (`S_id`) REFERENCES `Žival` (`Z_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Uporabnik`
--
ALTER TABLE `Uporabnik`
  ADD CONSTRAINT `Uporabnik_ibfk_1` FOREIGN KEY (`U_id`) REFERENCES `Koledar` (`KO_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Uporabnik_ibfk_2` FOREIGN KEY (`U_id`) REFERENCES `Komentar` (`K_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Uporabnik_ibfk_3` FOREIGN KEY (`U_id`) REFERENCES `Lokacija` (`L_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Žival`
--
ALTER TABLE `Žival`
  ADD CONSTRAINT `Žival_ibfk_1` FOREIGN KEY (`Z_id`) REFERENCES `Uporabnik` (`U_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
