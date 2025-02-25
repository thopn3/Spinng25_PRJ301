use master
go
create database PRJ301DB
go
use PRJ301DB
go
create table Categories(
	Id int identity(1,1) primary key,
	Name nvarchar(50),
	Description nvarchar(150)
)
go
create table Products
(
	Id int identity(1,1) primary key,
	[Name] nvarchar(100),
	Price int,
	Quantity int,
	CategoryId int not null,
	FOREIGN KEY (CategoryId) REFERENCES Categories(Id)
)
