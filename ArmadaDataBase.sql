
create database fleet;

use fleet;

create table ship (
ShipID int not null auto_increment,
ShipName varchar(50) not null,
MaxSpeed int not null,
CruisingSpeed int not null,
Cargo varChar(50) not null,
PRIMARY KEY (ShipID)
);

create table ShipLog (
ShipLogID int not null auto_increment,
ShipID int not null,
TypeOFCargo varchar(50),
CargoWeight int,
CurrentCoordinates varchar(7) not null,
DestinationCoordinates varchar(7),
StartCoordinates varchar(7) not null,
CurrentSpeed int,
NauticalMilage int,
Bearing varchar(2),
PRIMARY KEY (ShipLogID)
);

insert into shiplog(ShipID, CurrentCoordinates, DestinationCoordinates, StartCoordinates)
Values(1,"0,0", "0,99", "0,0");

insert into shiplog(ShipID, CurrentCoordinates, DestinationCoordinates, StartCoordinates)
Values(2,"0,0", "0,99", "0,0");
----
insert into shiplog(ShipID, CurrentCoordinates, DestinationCoordinates, StartCoordinates)
Values(3,"0,99", "0,0", "0,99");

insert into shiplog(ShipID, CurrentCoordinates, DestinationCoordinates, StartCoordinates)
Values(4,"0,99", "0,0", "0,99");
----
insert into shiplog(ShipID, CurrentCoordinates, DestinationCoordinates, StartCoordinates)
Values(5,"99,99", "0,0", "99,99");

insert into shiplog(ShipID, CurrentCoordinates, DestinationCoordinates, StartCoordinates)
Values(6,"99,99", "49,49", "99,99");

-----
insert into shiplog(ShipID, CurrentCoordinates, DestinationCoordinates, StartCoordinates)
Values(7,"49,49", "99,99", "49,49");

insert into shiplog(ShipID, CurrentCoordinates, DestinationCoordinates, StartCoordinates)
Values(8,"49,49", "0,99", "49,49");
---
insert into shiplog(ShipID, CurrentCoordinates, DestinationCoordinates, StartCoordinates)
Values(9,"99,99", "49,49", "99,99");

insert into shiplog(ShipID, CurrentCoordinates, DestinationCoordinates, StartCoordinates)
Values(10,"99,99", "49,49", "99,99");

--------------

insert into ship(ShipName, MaxSpeed, CruisingSpeed, Cargo)
VALUES("HMS Esteban", 20, 10, "Fruit");

insert into ship(ShipName, MaxSpeed, CruisingSpeed, Cargo)
VALUES("HMS Vasa1", 30, 20, "Fruit");

insert into ship(ShipName, MaxSpeed, CruisingSpeed, Cargo)
VALUES("M/S Sinaloa", 80, 60, "Alcohol");

insert into ship(ShipName, MaxSpeed, CruisingSpeed, Cargo)
VALUES("HSM Britt-Mari", 5, 6, "Livestock");

insert into ship(ShipName, MaxSpeed, CruisingSpeed, Cargo)
VALUES("HMS Boaty McBoatface", 10, 5, "Oil");

insert into ship(ShipName, MaxSpeed, CruisingSpeed, Cargo)
VALUES("HMS Vasa", 20, 10, "Oil");

insert into ship(ShipName, MaxSpeed, CruisingSpeed, Cargo)
VALUES("HMS Retail", 30, 10, "Clothes");

insert into ship(ShipName, MaxSpeed, CruisingSpeed, Cargo)
VALUES("Black Pearl", 30, 25, "Alcohol");

insert into ship(ShipName, MaxSpeed, CruisingSpeed, Cargo)
VALUES("S/S Flying Dutchman", 6, 4, "Alcohol");

insert into ship(ShipName, MaxSpeed, CruisingSpeed, Cargo)
VALUES("S/S Chris P Bacon", 11, 20, "Livestock");


select s.ShipName,s.Cargo, sl.TypeOfCargo, sl.CurrentCoordinates, sl.DestinationCoordinates
from ship s inner join shiplog sl
on s.ShipID = sl.ShipID


-- drop database fleet
