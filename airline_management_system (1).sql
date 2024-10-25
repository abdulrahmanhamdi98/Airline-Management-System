-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 25, 2024 at 09:51 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airline management system`
--

-- --------------------------------------------------------

--
-- Table structure for table `airplanes`
--

CREATE TABLE `airplanes` (
  `airplaneID` int(150) NOT NULL,
  `airplaneName` text NOT NULL,
  `airplaneType` text NOT NULL,
  `economyCapacity` int(150) NOT NULL,
  `businessCapacity` int(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `airplanes`
--

INSERT INTO `airplanes` (`airplaneID`, `airplaneName`, `airplaneType`, `economyCapacity`, `businessCapacity`) VALUES
(0, 'air', 'china', 50, 20);

-- --------------------------------------------------------

--
-- Table structure for table `airports`
--

CREATE TABLE `airports` (
  `airportID` int(15) NOT NULL,
  `airportName` text NOT NULL,
  `city` text NOT NULL,
  `country` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `airports`
--

INSERT INTO `airports` (`airportID`, `airportName`, `city`, `country`) VALUES
(10, 'ist', 'istanbul', 'turkye');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `employeeID` int(11) NOT NULL,
  `firstName` text NOT NULL,
  `lastName` text NOT NULL,
  `phoneNumber` text NOT NULL,
  `email` text NOT NULL,
  `position` text NOT NULL,
  `salary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`employeeID`, `firstName`, `lastName`, `phoneNumber`, `email`, `position`, `salary`) VALUES
(123, 'abd', 'abd', '525', 'abd@gmail.com', '50', 500);

-- --------------------------------------------------------

--
-- Table structure for table `flightemployees`
--

CREATE TABLE `flightemployees` (
  `flightID` int(11) NOT NULL,
  `employeeID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `flightpassengers`
--

CREATE TABLE `flightpassengers` (
  `flightID` int(11) NOT NULL,
  `passengerID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `flights`
--

CREATE TABLE `flights` (
  `flightID` int(11) NOT NULL,
  `airplaneID` int(11) NOT NULL,
  `airportID` int(11) NOT NULL,
  `destinationAirportID` int(11) NOT NULL,
  `departureTime` text NOT NULL,
  `arrivalTime` text NOT NULL,
  `isDelayed` text NOT NULL DEFAULT '0',
  `bookedEconomy` int(11) NOT NULL,
  `bookedBusiness` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flights`
--

INSERT INTO `flights` (`flightID`, `airplaneID`, `airportID`, `destinationAirportID`, `departureTime`, `arrivalTime`, `isDelayed`, `bookedEconomy`, `bookedBusiness`, `price`) VALUES
(11, 0, 10, 10, '2024-09-09::15:15:15', '2024-09-13::15:15:15', 'true', 10, 0, 500);

-- --------------------------------------------------------

--
-- Table structure for table `passengers`
--

CREATE TABLE `passengers` (
  `passengerID` int(11) NOT NULL,
  `FirstName` text NOT NULL,
  `LastName` text NOT NULL,
  `phoneNumber` text NOT NULL,
  `email` text NOT NULL,
  `nationality` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `passengers`
--

INSERT INTO `passengers` (`passengerID`, `FirstName`, `LastName`, `phoneNumber`, `email`, `nationality`) VALUES
(2021123029, 'abdulaziz', 'sayit', '051234', 'abd@gmail.com', 'eg'),
(2021123110, 'edip', 'ismail', '2546', 'abd@gmail.com', 'tr'),
(2021123119, 'abdulrahman', 'hamdi', '12354', 'abdulrahman@gmail.com', 'sy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `airplanes`
--
ALTER TABLE `airplanes`
  ADD PRIMARY KEY (`airplaneID`);

--
-- Indexes for table `airports`
--
ALTER TABLE `airports`
  ADD PRIMARY KEY (`airportID`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employeeID`);

--
-- Indexes for table `flightemployees`
--
ALTER TABLE `flightemployees`
  ADD PRIMARY KEY (`flightID`,`employeeID`),
  ADD KEY `employeeID` (`employeeID`);

--
-- Indexes for table `flightpassengers`
--
ALTER TABLE `flightpassengers`
  ADD PRIMARY KEY (`flightID`,`passengerID`),
  ADD KEY `passengerID` (`passengerID`);

--
-- Indexes for table `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`flightID`),
  ADD KEY `airplaneID` (`airplaneID`),
  ADD KEY `destinationAirportID` (`destinationAirportID`),
  ADD KEY `airportID` (`airportID`) USING BTREE;

--
-- Indexes for table `passengers`
--
ALTER TABLE `passengers`
  ADD PRIMARY KEY (`passengerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `flights`
--
ALTER TABLE `flights`
  MODIFY `flightID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `flightemployees`
--
ALTER TABLE `flightemployees`
  ADD CONSTRAINT `flightemployees_ibfk_1` FOREIGN KEY (`flightID`) REFERENCES `flights` (`flightID`),
  ADD CONSTRAINT `flightemployees_ibfk_2` FOREIGN KEY (`employeeID`) REFERENCES `employees` (`employeeID`);

--
-- Constraints for table `flightpassengers`
--
ALTER TABLE `flightpassengers`
  ADD CONSTRAINT `flightpassengers_ibfk_1` FOREIGN KEY (`flightID`) REFERENCES `flights` (`flightID`),
  ADD CONSTRAINT `flightpassengers_ibfk_2` FOREIGN KEY (`passengerID`) REFERENCES `passengers` (`passengerID`);

--
-- Constraints for table `flights`
--
ALTER TABLE `flights`
  ADD CONSTRAINT `flights_ibfk_1` FOREIGN KEY (`airplaneID`) REFERENCES `airplanes` (`airplaneID`),
  ADD CONSTRAINT `flights_ibfk_2` FOREIGN KEY (`airportID`) REFERENCES `airports` (`airportID`),
  ADD CONSTRAINT `flights_ibfk_3` FOREIGN KEY (`destinationAirportID`) REFERENCES `airports` (`airportID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
