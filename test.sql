-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2017 at 04:42 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE IF NOT EXISTS `classes` (
  `Class_dbid` int(11) NOT NULL,
  `ClassName` varchar(50) NOT NULL DEFAULT '0',
  `ClassCapacity` int(11) NOT NULL DEFAULT '0',
  `Instructor` varchar(50) NOT NULL DEFAULT '0',
  `Section` varchar(50) NOT NULL DEFAULT '0',
  `Day` varchar(50) NOT NULL DEFAULT '0',
  `Start` varchar(50) NOT NULL DEFAULT '00:00:00',
  `End` varchar(50) NOT NULL DEFAULT '00:00:00',
  `Units` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`Class_dbid`, `ClassName`, `ClassCapacity`, `Instructor`, `Section`, `Day`, `Start`, `End`, `Units`) VALUES
(1, 'JAVA 2 - Lecture', 30, 'Aniscal', 'A', 'Friday', '10am', '12pm', 3),
(2, 'Lab - JAVA 2', 30, 'Aniscal', 'A', 'Friday', '2pm', '5pm', 3),
(3, 'OOP - LEC', 30, 'Pelayo', 'B', 'Teusday', '10am', '12pm', 3),
(4, 'OOP - Lab', 30, 'Pelayo', 'B', 'Teusday', '2pm', '5pm', 3),
(5, 'Communication Skills 2', 30, 'Pelayo', 'A', 'Monday', '8am', '9am', 2);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `course_dbid` int(11) NOT NULL,
  `CourseName` varchar(50) NOT NULL,
  `Abbrevation` varchar(50) NOT NULL,
  `DegreeLevel` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_dbid`, `CourseName`, `Abbrevation`, `DegreeLevel`) VALUES
(1, 'Bachelor''s o Science in Inormation Technology', 'BSIT', 'Bachelor''s'),
(2, 'Bachelor''s of Science in Computer Science', 'BSCS', 'Bachelor''s'),
(3, 'Sotware Development', 'SD', 'Associates');

-- --------------------------------------------------------

--
-- Table structure for table `enrolled_to_classes`
--

CREATE TABLE IF NOT EXISTS `enrolled_to_classes` (
  `ec_id` int(11) NOT NULL,
  `ClassDetails` varchar(200) NOT NULL DEFAULT '0',
  `Firstname` varchar(50) NOT NULL DEFAULT '0',
  `Lastname` varchar(50) NOT NULL DEFAULT '0',
  `student_dbid` int(11) NOT NULL DEFAULT '0',
  `Class_dbid` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enrolled_to_classes`
--

INSERT INTO `enrolled_to_classes` (`ec_id`, `ClassDetails`, `Firstname`, `Lastname`, `student_dbid`, `Class_dbid`) VALUES
(1, 'JAVA 2 - Lecture Friday 10am 12pm', 'Sophia', 'Jamblang', 0, 0),
(2, 'Lab - JAVA 2 Friday 2pm 5pm', 'Sophia', 'Jamblang', 0, 0),
(3, 'JAVA 2 - Lecture Friday 10am 12pm', 'Logan', 'James', 0, 0),
(4, 'JAVA 2 - Lecture Friday 10am 12pm', 'Peter', 'Parker', 0, 0),
(5, 'Lab - JAVA 2 Friday 2pm 5pm', 'Sophia', 'Jamblang', 0, 0),
(6, 'JAVA 2 - Lecture Friday 10am 12pm', 'Bruce', 'Wayne', 0, 0),
(7, 'JAVA 2 - Lecture Friday 10am 12pm', 'Laura', 'Kinney', 0, 0),
(8, 'OOP - LEC Teusday 10am 12pm', 'Peter', 'Parker', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `instructors`
--

CREATE TABLE IF NOT EXISTS `instructors` (
  `Instructor_dbid` int(11) NOT NULL,
  `InstructorID` int(11) NOT NULL DEFAULT '0',
  `Firstname` varchar(50) NOT NULL DEFAULT '0',
  `Middlename` varchar(50) NOT NULL DEFAULT '0',
  `Lastname` varchar(50) NOT NULL DEFAULT '0',
  `Gender` varchar(50) NOT NULL DEFAULT '0',
  `Email` varchar(50) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructors`
--

INSERT INTO `instructors` (`Instructor_dbid`, `InstructorID`, `Firstname`, `Middlename`, `Lastname`, `Gender`, `Email`) VALUES
(1, 11235432, 'Mark', 'Dontknow', 'Aniscal', 'Male', 'aniscalmark.aclc@gmail.com'),
(2, 88383838, 'Mitch', 'Lakokabalo', 'Pelayo', 'Female', 'mitch@email.com'),
(3, 23212345, 'Melody', 'Tampi', 'Tenizo', 'Female', 'tenizo@aclc.com');

-- --------------------------------------------------------

--
-- Table structure for table `ratings`
--

CREATE TABLE IF NOT EXISTS `ratings` (
  `Ratings_dbid` int(11) NOT NULL,
  `Firstname` varchar(50) NOT NULL DEFAULT '0',
  `Lastname` varchar(50) NOT NULL DEFAULT '0',
  `ClassName` varchar(50) NOT NULL DEFAULT '0',
  `Semester` varchar(255) NOT NULL DEFAULT '0',
  `Prelim` double NOT NULL DEFAULT '0',
  `Midterm` double NOT NULL DEFAULT '0',
  `Prefinal` double NOT NULL DEFAULT '0',
  `Final` double NOT NULL DEFAULT '0',
  `OverallRating` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ratings`
--

INSERT INTO `ratings` (`Ratings_dbid`, `Firstname`, `Lastname`, `ClassName`, `Semester`, `Prelim`, `Midterm`, `Prefinal`, `Final`, `OverallRating`) VALUES
(1, 'Peter', 'Parker', 'JAVA 2 - Lecture', '2nd', 1.5, 1.75, 2, 2, 1.8125),
(2, 'Bruce', 'Wayne', 'OOP - Lab', '2nd', 1, 2, 2.25, 2.25, 1.875);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE IF NOT EXISTS `rooms` (
  `Room_dbid` int(11) NOT NULL,
  `RoomName` varchar(50) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`Room_dbid`, `RoomName`) VALUES
(1, '402'),
(2, '403'),
(3, '405');

-- --------------------------------------------------------

--
-- Table structure for table `section`
--

CREATE TABLE IF NOT EXISTS `section` (
  `section_id` int(11) NOT NULL,
  `SectionName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `section`
--

INSERT INTO `section` (`section_id`, `SectionName`) VALUES
(1, 'A'),
(2, 'B'),
(3, 'C');

-- --------------------------------------------------------

--
-- Table structure for table `student_fees`
--

CREATE TABLE IF NOT EXISTS `student_fees` (
  `Fees_dbid` int(11) NOT NULL,
  `student_dbid` int(11) NOT NULL DEFAULT '0',
  `Student_Firstname` varchar(50) NOT NULL DEFAULT '0',
  `Student_Lastname` varchar(50) NOT NULL DEFAULT '0',
  `Tuition` int(11) NOT NULL DEFAULT '0',
  `Miscellaneous` int(11) NOT NULL DEFAULT '0',
  `Lab Fee` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student_info`
--

CREATE TABLE IF NOT EXISTS `student_info` (
  `student_dbid` int(11) NOT NULL,
  `StudentID` int(11) NOT NULL DEFAULT '0',
  `Firstname` varchar(50) NOT NULL,
  `Middlename` varchar(50) NOT NULL,
  `Lastname` varchar(50) NOT NULL,
  `Age` int(11) NOT NULL,
  `Gender` varchar(50) NOT NULL,
  `Course` varchar(50) NOT NULL,
  `YearLevel` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`student_dbid`, `StudentID`, `Firstname`, `Middlename`, `Lastname`, `Age`, `Gender`, `Course`, `YearLevel`, `Email`) VALUES
(3, 1122323244, 'Jayson', 'Togonon', 'Lauza', 0, 'Male', 'BSCS', '1st', 'lauzajayson@gmail.com'),
(4, 112232323, 'Gideon', 'Medrano', 'Teves', 39, 'Male', 'BSIT', '2nd', 'gideon@gmail.com'),
(5, 2147483647, 'Joyce', 'Suasin', 'Escleto', 19, 'Female', 'BSIT', '1st', 'joyce@gmail.com'),
(6, 1122333, 'Jaymar', 'Random', 'Abrea', 20, 'Male', 'BSCS', '2nd', 'abrea@email.com'),
(7, 143, 'Sophia', 'Jamblang', 'Jamblang', 19, 'Female', 'BSCS', '2nd', 'sophia@yahoo.com'),
(8, 2232456, 'Logan', 'Wolverine', 'James', 60, 'Male', 'CGA', '4th', 'logan@x-men.om'),
(9, 2234565, 'Laura', 'Wolverine', 'Kinney', 14, 'Female', 'CAD', '1st', 'laura@x-men.com'),
(11, 11232333, 'Bruce', 'Batman', 'Wayne', 30, 'Male', 'CGA', '2nd', 'batman@justiceleague.com'),
(12, 12323454, 'Peter', 'Spiderman', 'Parker', 20, 'Male', 'BSIT', '2nd', 'spiderman@avengers.com');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userid` int(11) NOT NULL,
  `username` varchar(55) NOT NULL,
  `password` varchar(55) NOT NULL,
  `fname` varchar(55) NOT NULL,
  `lname` varchar(55) NOT NULL,
  `email` varchar(55) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `username`, `password`, `fname`, `lname`, `email`) VALUES
(1, 'admin', '123456', 'Jayson', 'Lauza', 'jlauzahyva@gmail.com'),
(2, 'user', '123456', 'Gideon', 'Teves', 'gideon@gmail.com'),
(3, 'jayson', '¬í\0ur\0[C°&f°â]„¬\0\0xp\0\0\0\01\02\03\04\05\06', 'Jayson', 'Lauza', 'jayson@email.com'),
(4, 'Admin', '¬í\0ur\0[C°&f°â]„¬\0\0xp\0\0\0\01\02\03\04\05\06', 'Jay', 'Lauza', 'jlauzahyva@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`Class_dbid`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_dbid`);

--
-- Indexes for table `enrolled_to_classes`
--
ALTER TABLE `enrolled_to_classes`
  ADD PRIMARY KEY (`ec_id`),
  ADD KEY `FK__student_info` (`student_dbid`),
  ADD KEY `Class_dbid` (`Class_dbid`);

--
-- Indexes for table `instructors`
--
ALTER TABLE `instructors`
  ADD PRIMARY KEY (`Instructor_dbid`);

--
-- Indexes for table `ratings`
--
ALTER TABLE `ratings`
  ADD PRIMARY KEY (`Ratings_dbid`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`Room_dbid`);

--
-- Indexes for table `section`
--
ALTER TABLE `section`
  ADD PRIMARY KEY (`section_id`);

--
-- Indexes for table `student_fees`
--
ALTER TABLE `student_fees`
  ADD PRIMARY KEY (`Fees_dbid`),
  ADD KEY `student_dbid` (`student_dbid`);

--
-- Indexes for table `student_info`
--
ALTER TABLE `student_info`
  ADD PRIMARY KEY (`student_dbid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `classes`
--
ALTER TABLE `classes`
  MODIFY `Class_dbid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `course_dbid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `enrolled_to_classes`
--
ALTER TABLE `enrolled_to_classes`
  MODIFY `ec_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `instructors`
--
ALTER TABLE `instructors`
  MODIFY `Instructor_dbid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `ratings`
--
ALTER TABLE `ratings`
  MODIFY `Ratings_dbid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `Room_dbid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `section`
--
ALTER TABLE `section`
  MODIFY `section_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `student_fees`
--
ALTER TABLE `student_fees`
  MODIFY `Fees_dbid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `student_info`
--
ALTER TABLE `student_info`
  MODIFY `student_dbid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
