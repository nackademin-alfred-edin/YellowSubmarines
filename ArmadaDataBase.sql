-- drop database fleet
create database fleet;

use fleet;

create table ship (
ShipID int not null auto_increment,
ShipName varchar(50) not null,
MaxCargoWeight int,
MaxSpeed int not null,
CruisingSpeed int not null,
Cargo varChar(50) not null,
PRIMARY KEY (ShipID)
);

create table ShipLog (
ShipLogID int not null auto_increment,
ShipID int not null,
CurrentCoordinates varchar(7) not null,
DestinationCoordinates varchar(7),
StartCoordinates varchar(7) not null,
CurrentSpeed int,
NauticalMilage int,
Bearing varchar(2),
Route varchar(50),
PRIMARY KEY (ShipLogID)
);



insert into ship(ShipName, MaxCargoWeight, MaxSpeed, CruisingSpeed, Cargo)
VALUES
("HMS Esteban", 100, 40, 10, "Oil"),
("HMS G.Vasa", 59, 40, 20, "Container"),
("M/S Sinaloa", 43, 40, 30, "Oil"),
("HSM Britt-Mari", 56, 40, 10, "Container"),
("HMS Boaty McBoatface", 62, 40, 20, "Oil"),
("HMS Retail", 76, 40, 10, "Container"),
("Black Pearl", 234, 40, 40, "Oil"),
("S/S Flying Dutchman", 52, 40, 10, "Container"),
("S/S Chris P Bacon", 51, 40, 40, "Oil"),
("HMS Vasa", 512, 40, 40, "Container");

insert into shiplog(ShipID, CurrentCoordinates, StartCoordinates, Route)
Values
(1,"0,0", "0,0", "99,99-49,49-0,0"),
(2,"0,0", "0,0", "49,49-0,99-99,99"),
(3,"0,99", "0,99", "0,0-99,0-49,49"),
(4,"0,99","0,99", "49,49-0,99-99,0"),
(5,"99,0", "99,0", "0,99-0,0-0,99"),
(6,"99,0", "99,0", "49,49-0,0-0,99"),
(7,"99,99", "99,99", "99,0-0,0-99,99"),
(8,"99,99", "99,99", "0,99-99,99-49,49"),
(9,"49,49", "49,49", "0,0-0,99-99,00"),
(10,"49,49","49,49", "99,99-99,0-99,99");


select s.ShipName,s.Cargo, sl.CurrentCoordinates, sl.DestinationCoordinates, s.CruisingSpeed
from ship s inner join shiplog sl
on s.ShipID = sl.ShipID;

-- ShipInfo
-- CREATE VIEW uvShipInfo AS
-- Select s.ShipName , s.CruisingSpeed, sl.CargoWeight, sl.CurrentCoordinates, sl.Bearing, sl.DestinationCoordinates, sl.NauticalMilage
-- from ship s inner join shiplog sl
-- on s.ShipId = sl.ShipId;


-- Get all ship postition
CREATE VIEW uvshipposition AS
select s.ShipName, sl.Bearing, sl.CurrentCoordinates
from ship s inner join shiplog sl
on s.ShipId = sl.ShipId;


-- View to  populate java code
Create view uvships as
select s.ShipID, s.ShipName, s.MaxCargoWeight, s.MaxSpeed, s.CruisingSpeed, s.Cargo, sl.ShipLogID, sl.CurrentCoordinates, sl.DestinationCoordinates, sl.StartCoordinates, sl.CurrentSpeed, sl.NauticalMilage, sl.Bearing, sl.Route
from ship s inner join shiplog sl
on s.ShipId = sl.ShipId

-- Stored Procedure to update start coordinates
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE uspUpdateStartCoordinates(sID int, slID int, coordinates varchar(20))
BEGIN
    update shiplog
    set StartCoordinates = coordinates
    where ShipLogID = slID and ShipId = sID;
END$$
DELIMITER ;

-- Stored Procedure to update current coordinates
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE uspUpdateCurrentCoordinates(sID int, slID int, coordinates varchar(20))
BEGIN
    update shiplog
    set CurrentCoordinates = coordinates
    where ShipLogID = slID and ShipId = sID;
END$$
DELIMITER ;

-- Stored Procedure to update destination coordinates
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE uspUpdateDestinationCoordinates(sID int, slID int, coordinates varchar(20))
BEGIN
    update shiplog
    set DestinationCoordinates = coordinates
    where ShipLogID = slID and ShipId = sID;
END$$
DELIMITER ;

