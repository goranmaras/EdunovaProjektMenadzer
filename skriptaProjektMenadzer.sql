drop database if exists ProjektMenadzer;
create database ProjektMenadzer default character set utf8;
use ProjektMenadzer ;

# c:\xampp\mysql\bin\mysql.exe -uedunova -pedunova --default-character-set=utf8 < C:\Users\Abraxas\Desktop\EdunovajpProjekt\skriptaProjektMenadzer.sql

create table djelatnik (
    sifra int not null primary key auto_increment,
    ime varchar(50) not null default '',
    prezime varchar(50) not null default '',
    email varchar(50),
    br_tel varchar(20),
    cijena_sata decimal(18,2),
    prog_jezik varchar(50)
);

create table klijent (
    sifra int not null primary key auto_increment,
    ime varchar(50) not null,
    prezime varchar(50) not null,
    email varchar(50),
    br_tel varchar(20),
    ime_firme varchar(50)
);

create table tim (
    sifra int not null primary key auto_increment,
    naziv varchar(50) not null,
    br_clanova int 
);

create table clan_tima(
    djelatnik int not null,
    tim int not null
);

create table projekt(
    sifra int not null primary key auto_increment,
    klijent int not null, 
    naziv varchar(50) not null,
    vrijeme_pocetka date,
    vrijeme_zavrsetka date,
    br_zadataka int
);

create table zadatak(
    projekt int not null,
    tim int not null,
    naziv varchar(50) not null
);

alter table clan_tima add foreign key (djelatnik) references djelatnik(sifra);
alter table clan_tima add foreign key (tim) references tim(sifra);

alter table projekt add foreign key (klijent) references klijent(sifra);

alter table zadatak add foreign key (projekt) references projekt(sifra);
alter table zadatak add foreign key (tim) references tim(sifra);

insert into djelatnik (ime,prezime,br_tel,cijena_sata,prog_jezik) values
('Ambrozije','Marić','0983945236',55.00,'Java'),
('Leon','Filipović','0915678533',47.00,'C++'),
('Petar','Zorov','0993953019',50.00,'Java'),
('Drago','Stojanović','0926234522',48.00,'Phyton'),
('Vilma','Herceg','0983423216',52.00,'C#, C++'),
('Radovan','Dragić','0919658345',50.00,'Phyton'),
('Vladisla','Adamov','0959029629',45.00,'Baze podataka'),
('Gabrijel','Marinov','0952345964',43.00,'Baze podataka'),
('Antonija','Jurić','0958345324',40.00,'Html, Css'),
('Tihomir','Radić','091343666',40.00,'Html, Css'),
('Ljubmir','Tomović','091251343',48.00,'Server'),
('Edi','Kovačić','0910430963',50.00,'Server'),
('Jakša','Juriša','0980103215',53.00,'server');

insert into klijent (ime,prezime,br_tel,ime_firme) values
('Darko','Kokot','0950293023','Kokuz'),
('Iskra','Petrić','0912314333','iIskra'),
('Pejo','Filipović','0981204523','Security'),
('Nediljko','Vinković','0994324052','BitMoney');

drop function if exists email;
DELIMITER $$
CREATE FUNCTION email(ime varchar(50), prezime varchar(50)) RETURNS varchar(255)
begin
return concat(left(lower(ime),1),'.', lower(
replace(
replace(
replace(
replace(
replace(replace(upper(prezime),' ',''),'Č','C')
,'Š','S')
,'Đ','D')
,'Ć','C')
,'Ž','Z')
), '@gmail.com');
end;
$$
DELIMITER ;
update djelatnik
set email = email(ime,prezime)
where sifra<=13;

drop function if exists email1;
delimiter $$
create function email1(ime_firme varchar(50)) returns varchar(255)
begin
	return concat(lower(ime_firme),'@info.hr');
	
end;
$$
delimiter ;
update klijent
set email=email1(ime_firme)
where sifra <=4;


insert into tim (naziv,br_clanova) values
('Programeri',6),
('Webeovci',2),
('Bazni', 2),
('Server odrzavatelji',3);

insert into clan_tima(djelatnik,tim) select sifra,1 from djelatnik where sifra <=6;
insert into clan_tima(djelatnik,tim) select sifra,2 from djelatnik where sifra >6 and sifra<=8;
insert into clan_tima(djelatnik,tim) select sifra,3 from djelatnik where sifra >8 and sifra<=10;
insert into clan_tima(djelatnik,tim) select sifra,4 from djelatnik where sifra >10 and sifra<=13;

insert into projekt(klijent,naziv,vrijeme_pocetka,vrijeme_zavrsetka,br_zadataka) values
(1,'Web stranica www.kokus.com','2019-03-19','2019-05-02',2),
(2,'Izrada programa za prepoznavanje lica(MachineLearning)','2018-05-19','2019-11-20',3),
(3,'Java aplikacija za raspored smjena','2019-08-27','2019-12-15',2),
(4,'Web stranica za praćenje BitCoin vrijednosti www.bitvalue.com','2018-12-11','2019-01-24',2);

insert into zadatak(projekt,tim,naziv) values
(1,4,'Izrada servera za kokus.com'),
(1,2,'Izrada web stranice www.kokus.com'),
(3,1,'Izrada java aplikacije'),
(3,1,'Testiranje java aplikacije'),
(2,1,'Postavljanje programa za prepoznavanje lica'),
(2,1,'Uredjivanje sučelja u C# za program prepoznavanja lica'),
(2,1,'Testiranje i stavljanje AI-a na proces razvijanja'),
(4,4,'Izrada servera za bitvalue.com'),
(4,2,'Izrada web stranice www.bitvalue.com');


