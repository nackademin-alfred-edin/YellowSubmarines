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
("HMS Esteban", 100, 40, 30, "Oil"),
("HMS G.Vasa", 59, 40, 30, "Container"),
("M/S Sinaloa", 43, 40, 30, "Oil"),
("HSM Britt-Mari", 56, 40, 30, "Container"),
("HMS Boaty McBoatface", 62, 40, 20, "Oil"),
("HMS Retail", 76, 30, 10, "Container"),
("Black Pearl", 234, 30, 40, "Oil"),
("S/S Flying Dutchman", 52, 40, 10, "Container"),
("S/S Chris P Bacon", 51, 40, 40, "Oil"),
("HMS Vasa", 512, 40, 40, "Container");

insert into shiplog(ShipID, CurrentCoordinates, StartCoordinates, Route, DestinationCoordinates, CurrentSpeed)
Values
(1,"0,0", "0,0", "99,99-49,49-0,0","99,99", "40"),
(2,"0,0", "0,0", "49,49-0,99-99,99", "49,49", "40"),
(3,"0,99", "0,99", "0,0-99,0-49,49", "0,0", "20"),
(4,"0,99","0,99", "49,49-0,99-99,0", "49,49", "20"),
(5,"99,0", "99,0", "0,99-0,0-0,99", "0,99", "30"),
(6,"99,0", "99,0", "49,49-0,0-0,99", "49,49", "40"),
(7,"99,99", "99,99", "99,0-0,0-99,99", "99,0", "20"),
(8,"99,99", "99,99", "0,99-99,99-49,49", "0,99", "10"),
(9,"49,49", "49,49", "0,0-0,99-99,00", "0,0","40"),
(10,"49,49","49,49", "99,99-99,0-99,99", "99,99","40");


select s.ShipName,s.Cargo, sl.CurrentCoordinates, sl.DestinationCoordinates, s.CruisingSpeed
from ship s inner join shiplog sl
on s.ShipID = sl.ShipID;

-- Get all ship postition
CREATE VIEW uvshipposition AS
select s.ShipName, sl.Bearing, sl.CurrentCoordinates
from ship s inner join shiplog sl
on s.ShipId = sl.ShipId;

-- View to  populate java code
Create view uvships as
select s.ShipID, s.ShipName, s.MaxCargoWeight, s.MaxSpeed, s.CruisingSpeed, s.Cargo, sl.ShipLogID, sl.CurrentCoordinates, sl.DestinationCoordinates, sl.StartCoordinates, sl.CurrentSpeed, sl.NauticalMilage, sl.Bearing, sl.Route
from ship s inner join shiplog sl
on s.ShipId = sl.ShipId;

-- Stored Procedure to update current coordinates
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE uspUpdateCurrentCoordinatesAndBearing(sID int, slID int, coordinates varchar(20), bearing varchar(2))
BEGIN
    update shiplog
    set CurrentCoordinates = coordinates, Bearing = bearing
    where ShipLogID = slID and ShipId = sID;
END$$
DELIMITER ;

-- Stored Procedure to update Route coordinates
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE uspUpdateRouteDestinationStartCoordinates(sID int, slID int, route varchar(20), dest varchar(20), start varchar(20))
BEGIN
    update shiplog
    set Route = route, DestionationCoordinates = destCoord , StartCoordinates = startCoord
    where ShipLogID = slID and ShipId = sID;
END$$
DELIMITER ;

select * from uvships