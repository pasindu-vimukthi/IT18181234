-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 02:42 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aaaa`
--

-- --------------------------------------------------------

--
-- Table structure for table `ambu`
--

CREATE TABLE `ambu` (
  `driverID` int(11) NOT NULL,
  `driverCode` varchar(10) CHARACTER SET latin1 NOT NULL,
  `driverName` varchar(30) CHARACTER SET latin1 NOT NULL,
  `mobileNo` varchar(10) CHARACTER SET latin1 NOT NULL,
  `vehicleNo` varchar(8) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ambu`
--

INSERT INTO `ambu` (`driverID`, `driverCode`, `driverName`, `mobileNo`, `vehicleNo`) VALUES
(5, 'D1239', 'joney', '214785', 'ND1234'),
(12, 'D352', 'Pasindu', '779093936', 'VR6754'),
(16, 'D3232', 'trishan', '2312345', 'PB4321'),
(17, 'D666', 'gamith', '9087654', 'PB4258'),
(18, 'D789', 'Nisaga', '259863741', 'PD2345'),
(19, 'D099', 'gayan', '852369740', 'FH6789');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ambu`
--
ALTER TABLE `ambu`
  ADD PRIMARY KEY (`driverID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ambu`
--
ALTER TABLE `ambu`
  MODIFY `driverID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
