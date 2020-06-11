-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `game`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `Firstname` varchar(20) DEFAULT NULL,
  `Lastname` varchar(20) DEFAULT NULL,
  `Username` varchar(20) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`Firstname`, `Lastname`, `Username`, `Password`, `user_id`) VALUES
('Kay', 'D', 'KayD', 'KayD', 1),
('Den', 'Esu', 'Densu', 'Densu', 2);

-- --------------------------------------------------------

--
-- Table structure for table `words`
--

CREATE TABLE `words` (
  `word` varchar(20) DEFAULT NULL,
  `hint` varchar(200) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `word_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `words`
--

INSERT INTO `words` (`word`, `hint`, `level`, `word_id`) VALUES
('FORUM', 'A PLACE FOR DISCUSSION', 3, 1),
('ACUTE', 'KEENLY PERCEPTIVE', 3, 2),
('PROXY', 'A SUBSITUTE FOR SOMETHING', 3, 3),
('CAUSE', 'THE REASON FOR AN ACTION', 3, 4),
('ABUSE', 'TO MISHANDLE', 3, 5),
('RANK', 'A HIERARCHICAL LEVEL IN AN ORGANISATION', 2, 6),
('LOGO', 'A VISUAL EMBLEM OF AN ORGANISATION', 2, 7),
('FORT', 'A FORTIFIED DEFENSIVE STRUCTURE', 2, 8),
('ABLE', 'ABILITY TO DO', 2, 9),
('BANK', 'ESTABLISHMENT WHERE MONEY IS KEPT', 2, 10),
('ACE', 'SUCCEED EASILY', 1, 11),
('AIR', 'MIXTURE OF GASES', 1, 12),
('AWE', 'A FEELING OF AMAZEMENT', 1, 13),
('SLY', 'TO BE ARTFULLY CUNNING', 1, 14),
('WRY', 'SOMETHING TWISTED', 1, 15);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `words`
--
ALTER TABLE `words`
  ADD PRIMARY KEY (`word_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_details`
--
ALTER TABLE `user_details`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `words`
--
ALTER TABLE `words`
  MODIFY `word_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
