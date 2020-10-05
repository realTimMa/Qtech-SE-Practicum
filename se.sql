drop database if exists `se`;
create database `se` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

create table se.Usertable(
UserID INT(9) primary key auto_increment,
Username char(10) not null,
Userpass char(10) not null
);

create table se.Admtable(
Admname char(10) primary key,
Admpass char(10) not null
);

create table se.Sectable(
Secname char(10) primary key,
Secpass char(10) not null
);

create table se.Tasktable(
TaskID int(9) primary key auto_increment,
Taskname char(10) not null,
Taskcate char(10) not null,
Jan char(10),
Feb char(10),
Mar char(10),
Apr char(10),
May char(10),
Jun char(10),
Jul char(10),
Aug char(10),
Sept char(10),
Oct char(10),
Nov char(10),
Dece char(10),
Department char(50) not null,
Principal char(50) not null,
Assistant char(50) not null,
Performance char(50),
Grade int(10),
Weight int(10)
);

create table se.principal(
taskId INT(11) primary key,
taskPrcp char(10),
taskGrade INT(11),
taskWeight INT(11)
);

create table se.month(
taskId INT(11) primary key,
taskName varchar(50),
task varchar(50),
taskDept varchar(50)
);

insert into se.Admtable(Admname,Admpass) values("adm","123");
insert into se.Sectable(Secname,Secpass) values("sec","123");

