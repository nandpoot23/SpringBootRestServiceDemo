Enter password: ****
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 42
Server version: 5.5.18 MySQL Community Server (GPL)

Copyright (c) 2000, 2011, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| springboot         |
| springcustomer     |
| test               |
+--------------------+
6 rows in set (0.07 sec)

mysql> use springcustomer;
Database changed

mysql> show tables;
Empty set (0.00 sec)

mysql> CREATE TABLE customer(
    -> ID int(11) NOT NULL AUTO_INCREMENT,
    -> FirstName varchar(75),
    -> LastName varchar(75) NOT NULL,
    -> Address varchar(55),
    -> City varchar(55),
    -> PRIMARY KEY (ID)
    -> );
Query OK, 0 rows affected (0.31 sec)

mysql> desc customer;
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| ID        | int(11)     | NO   | PRI | NULL    | auto_increment |
| FirstName | varchar(75) | YES  |     | NULL    |                |
| LastName  | varchar(75) | NO   |     | NULL    |                |
| Address   | varchar(55) | YES  |     | NULL    |                |
| City      | varchar(55) | YES  |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+
5 rows in set (0.07 sec)

mysql> insert into customer(FirstName, LastName, Address, City) values("Roopa",
"G", "Sec49", "BNDA");
Query OK, 1 row affected (0.05 sec)

mysql> select * from customer;
+----+-----------+----------+---------+------+
| ID | FirstName | LastName | Address | City |
+----+-----------+----------+---------+------+
|  1 | Roopa     | G        | Sec49   | BNDA |
+----+-----------+----------+---------+------+
1 row in set (0.00 sec)

mysql> insert into customer(FirstName, LastName, Address, City) values("Roli", "
G", "Sec49", "BNDA");
Query OK, 1 row affected (0.02 sec)

mysql> insert into customer(FirstName, LastName, Address, City) values("Swati",
"G", "Sec49", "NOIDA");
Query OK, 1 row affected (0.01 sec)

mysql> insert into customer(FirstName, LastName, Address, City) values("Ekta", "
G", "Sec49", "BNDA");
Query OK, 1 row affected (0.01 sec)

mysql> insert into customer(FirstName, LastName, Address, City) values("Shraddha
", "G", "Sec49", "NOIDA");
Query OK, 1 row affected (0.02 sec)

mysql> select * from customer;
+----+-----------+----------+---------+-------+
| ID | FirstName | LastName | Address | City  |
+----+-----------+----------+---------+-------+
|  1 | Roopa     | G        | Sec49   | BNDA  |
|  2 | Roli      | G        | Sec49   | BNDA  |
|  3 | Swati     | G        | Sec49   | NOIDA |
|  4 | Ekta      | G        | Sec49   | BNDA  |
|  5 | Shraddha  | G        | Sec49   | NOIDA |
+----+-----------+----------+---------+-------+
5 rows in set (0.00 sec)

mysql> CREATE TABLE customerEmail(FirstName varchar(75) NOT NULL, Email varchar(75) NOT NULL);

mysql> desc customerEmail;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| FirstName | varchar(75) | NO   |     | NULL    |       |
| Email     | varchar(75) | NO   |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
2 rows in set (0.02 sec)

insert into customerEmail(FirstName, Email) values("Roli", "r@gmail.com");
insert into customerEmail(FirstName, Email) values("Sonal", "s@gmail.com");
insert into customerEmail(FirstName, Email) values("Komal", "k@gmail.com");
insert into customerEmail(FirstName, Email) values("Pooja", "p@gmail.com");
insert into customerEmail(FirstName, Email) values("Shraddha", "sh@gmail.com");
Query OK, 5 row affected (0.10 sec)

mysql> select * from customerEmail;
+-----------+--------------+
| FirstName | Email        |
+-----------+--------------+
| Roli      | r@gmail.com  |
| Sonal     | s@gmail.com  |
| Komal     | k@gmail.com  |
| Pooja     | p@gmail.com  |
| Shraddha  | sh@gmail.com |
+-----------+--------------+
5 rows in set (0.00 sec)

mysql> CREATE TABLE item(
    -> ItemID varchar(20) NOT NULL,
    -> ItemName varchar(75) NOT NULL,
    -> ItemCode varchar(75) NOT NULL,
    -> ItemType varchar(55) NOT NULL,
    -> ItemValue varchar(55) NOT NULL);
Query OK, 0 rows affected (0.07 sec)

mysql> desc item;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| ItemID    | varchar(20) | NO   |     | NULL    |       |
| ItemName  | varchar(75) | NO   |     | NULL    |       |
| ItemCode  | varchar(75) | NO   |     | NULL    |       |
| ItemType  | varchar(55) | NO   |     | NULL    |       |
| ItemValue | varchar(55) | NO   |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
5 rows in set (0.01 sec)

insert into item(ItemID, ItemName, ItemCode, ItemType, ItemValue) values("I1", "Apple", "APP01", "Home", "150000");
insert into item(ItemID, ItemName, ItemCode, ItemType, ItemValue) values("I2", "Mac", "MAC01", "Home", "300000");
insert into item(ItemID, ItemName, ItemCode, ItemType, ItemValue) values("I3", "Guava", "GUV01", "Home", "45000");
insert into item(ItemID, ItemName, ItemCode, ItemType, ItemValue) values("I4", "Pumpkin", "PUP01", "Office", "5000");
insert into item(ItemID, ItemName, ItemCode, ItemType, ItemValue) values("I5", "Sitaphal", "STP01", "Home", "2000");
Query OK, 5 row affected (0.10 sec)

mysql> select * from item;
+--------+----------+----------+----------+-----------+
| ItemID | ItemName | ItemCode | ItemType | ItemValue |
+--------+----------+----------+----------+-----------+
| I1     | Apple    | APP01    | Home     | 150000    |
| I2     | Mac      | MAC01    | Home     | 300000    |
| I3     | Guava    | GUV01    | Home     | 45000     |
| I4     | Pumpkin  | PUP01    | Office   | 5000      |
| I5     | Sitaphal | STP01    | Home     | 2000      |
+--------+----------+----------+----------+-----------+
5 rows in set (0.00 sec)

mysql> CREATE TABLE Market(
    -> MarketId NUMERIC(22) NOT NULL, TermTextId NUMERIC(22) NOT NULL,
    -> CorpCd varchar(20) NOT NULL, MyAgt varchar(75) NOT NULL, MrktName varchar
(75) NOT NULL,
    -> TermTextTitle varchar(25) NOT NULL, Description varchar(75) NOT NULL,
    -> AccountNumber varchar(20) NOT NULL, CustomerId varchar(20) NOT NULL, Cust
omerStatus varchar(10) NOT NULL,
    -> ActiveStartDate DATE NOT NULL, ActiveEndDate DATE NOT NULL,
    -> ActiveFlag CHAR(1) NOT NULL, Version NUMERIC(5) NOT NULL);
Query OK, 0 rows affected (0.08 sec)

mysql> desc Market;
+-----------------+---------------+------+-----+---------+-------+
| Field           | Type          | Null | Key | Default | Extra |
+-----------------+---------------+------+-----+---------+-------+
| MarketId        | decimal(22,0) | NO   |     | NULL    |       |
| TermTextId      | decimal(22,0) | NO   |     | NULL    |       |
| CorpCd          | varchar(20)   | NO   |     | NULL    |       |
| MyAgt           | varchar(75)   | NO   |     | NULL    |       |
| MrktName        | varchar(75)   | NO   |     | NULL    |       |
| TermTextTitle   | varchar(25)   | NO   |     | NULL    |       |
| Description     | varchar(75)   | NO   |     | NULL    |       |
| AccountNumber   | varchar(20)   | NO   |     | NULL    |       |
| CustomerId      | varchar(20)   | NO   |     | NULL    |       |
| CustomerStatus  | varchar(10)   | NO   |     | NULL    |       |
| ActiveStartDate | date          | NO   |     | NULL    |       |
| ActiveEndDate   | date          | NO   |     | NULL    |       |
| ActiveFlag      | char(1)       | NO   |     | NULL    |       |
| Version         | decimal(5,0)  | NO   |     | NULL    |       |
+-----------------+---------------+------+-----+---------+-------+
14 rows in set (0.06 sec)

mysql> insert into Market(MarketId, TermTextId, CorpCd, MyAgt, MrktName, TermTex
tTitle, Description, AccountNumber,
    -> CustomerId, CustomerStatus, ActiveStartDate, ActiveEndDate, ActiveFlag, V
ersion)
    -> values('1423', '1000', "COR01", "Mahesh", "Super Market", "Cond", "Term T
ext Description",
    -> "95826", "04100", "true", '2011-01-24', '2016-12-24', 'Y', '1');
Query OK, 1 row affected (0.04 sec)

mysql> select * from Market;
+----------+------------+--------+--------+--------------+---------------+------
-----------------+---------------+------------+----------------+----------------
-+---------------+------------+---------+
| MarketId | TermTextId | CorpCd | MyAgt  | MrktName     | TermTextTitle | Descr
iption           | AccountNumber | CustomerId | CustomerStatus | ActiveStartDate
 | ActiveEndDate | ActiveFlag | Version |
+----------+------------+--------+--------+--------------+---------------+------
-----------------+---------------+------------+----------------+----------------
-+---------------+------------+---------+
|     1423 |       1000 | COR01  | Mahesh | Super Market | Cond          | Term
Text Description | 95826         | 04100      | true           | 2011-01-24
 | 2016-12-24    | Y          |       1 |
+----------+------------+--------+--------+--------------+---------------+------
-----------------+---------------+------------+----------------+----------------
-+---------------+------------+---------+
1 row in set (0.00 sec)

insert into Market(MarketId, TermTextId, CorpCd, MyAgt, MrktName, TermTextTitle, Description, AccountNumber,
CustomerId, CustomerStatus, ActiveStartDate, ActiveEndDate, ActiveFlag, Version) 
values('1423', '1000', "COR01", "Mahesh", "Super Market", "Cond", "Term Text Description",
"95826", "04100", "true", '2011-01-24', '2016-12-24', 'Y', '1');

insert into Market(MarketId, TermTextId, CorpCd, MyAgt, MrktName, TermTextTitle, Description, AccountNumber,
CustomerId, CustomerStatus, ActiveStartDate, ActiveEndDate, ActiveFlag, Version) 
values('1425', '1001', "COR02", "Manu", "Star Market", "Cond", "Term Text Description",
"15826", "14100", "false", '2011-01-24', '2017-12-24', 'N', '2');

insert into Market(MarketId, TermTextId, CorpCd, MyAgt, MrktName, TermTextTitle, Description, AccountNumber,
CustomerId, CustomerStatus, ActiveStartDate, ActiveEndDate, ActiveFlag, Version) 
values('1427', '1005', "COR03", "Manul", "Star Market", "Cond", "Term Text Description",
"15827", "14101", "true", '2011-01-24', '2018-12-24', 'Y', '3');

mysql> select * from Market;
+----------+------------+--------+--------+--------------+---------------+------
-----------------+---------------+------------+----------------+----------------
-+---------------+------------+---------+
| MarketId | TermTextId | CorpCd | MyAgt  | MrktName     | TermTextTitle | Descr
iption           | AccountNumber | CustomerId | CustomerStatus | ActiveStartDate
 | ActiveEndDate | ActiveFlag | Version |
+----------+------------+--------+--------+--------------+---------------+------
-----------------+---------------+------------+----------------+----------------
-+---------------+------------+---------+
|     1423 |       1000 | COR01  | Mahesh | Super Market | Cond          | Term
Text Description | 95826         | 04100      | true           | 2011-01-24
 | 2016-12-24    | Y          |       1 |
|     1425 |       1001 | COR02  | Manu   | Star Market  | Cond          | Term
Text Description | 15826         | 14100      | false          | 2011-01-24
 | 2017-12-24    | N          |       2 |
|     1427 |       1005 | COR03  | Manul  | Star Market  | Cond          | Term
Text Description | 15827         | 14101      | true           | 2011-01-24
 | 2018-12-24    | Y          |       3 |
+----------+------------+--------+--------+--------------+---------------+------
-----------------+---------------+------------+----------------+----------------
-+---------------+------------+---------+
3 rows in set (0.00 sec)

CREATE TABLE Vendor(
VendorID varchar(20) NOT NULL,
VendorName varchar(75) NOT NULL,
VendorCode varchar(75) NOT NULL,
VendorType varchar(55) NOT NULL,
VendorValue varchar(55) NOT NULL);

mysql> desc Vendor;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| VendorID    | varchar(20) | NO   |     | NULL    |       |
| VendorName  | varchar(75) | NO   |     | NULL    |       |
| VendorCode  | varchar(75) | NO   |     | NULL    |       |
| VendorType  | varchar(55) | NO   |     | NULL    |       |
| VendorValue | varchar(55) | NO   |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
5 rows in set (0.15 sec)

insert into Vendor(VendorID, VendorName, VendorCode, VendorType, VendorValue) values
("V1", "Haven", "HEV01", "Food", "150000");

insert into Vendor(VendorID, VendorName, VendorCode, VendorType, VendorValue) values
("V2", "High", "HIG01", "Food", "450000");

insert into Vendor(VendorID, VendorName, VendorCode, VendorType, VendorValue) values
("V3", "Fighy", "FIG01", "Cater", "950000");

insert into Vendor(VendorID, VendorName, VendorCode, VendorType, VendorValue) values
("V4", "Super", "SUP01", "Cater", "450000");

insert into Vendor(VendorID, VendorName, VendorCode, VendorType, VendorValue) values
("V5", "Honey", "HON01", "Food", "250000");

mysql> select * from Vendor;
+----------+------------+------------+------------+-------------+
| VendorID | VendorName | VendorCode | VendorType | VendorValue |
+----------+------------+------------+------------+-------------+
| V1       | Haven      | HEV01      | Food       | 150000      |
| V2       | High       | HIG01      | Food       | 450000      |
| V3       | Fighy      | FIG01      | Cater      | 950000      |
| V4       | Super      | SUP01      | Cater      | 450000      |
| V5       | Honey      | HON01      | Food       | 250000      |
+----------+------------+------------+------------+-------------+
5 rows in set (0.00 sec)

CREATE TABLE Offer(
CustomerOfferID varchar(20) NOT NULL,
OfferNumber varchar(75) NOT NULL,
CustomerID varchar(75) NOT NULL,
EffectiveDate Date NOT NULL,
IsSynchronized varchar(20) NOT NULL);
Query OK, 0 rows affected (0.07 sec)

insert into Offer(CustomerOfferID, OfferNumber, CustomerID, EffectiveDate, IsSynchronized) 
values("Offer1", "23", "APR01", '2011/01/25', 'true');

insert into Offer(CustomerOfferID, OfferNumber, CustomerID, EffectiveDate, IsSynchronized) 
values("Offer2", "14", "APR02", '2011/01/25', 'false');

insert into Offer(CustomerOfferID, OfferNumber, CustomerID, EffectiveDate, IsSynchronized) 
values("Offer3", "1223", "APR03", '2012/01/25', 'false');

insert into Offer(CustomerOfferID, OfferNumber, CustomerID, EffectiveDate, IsSynchronized) 
values("Offer4", "1423", "APR04", '2014/01/25', 'true');

insert into Offer(CustomerOfferID, OfferNumber, CustomerID, EffectiveDate, IsSynchronized) 
values("Offer5", "12345", "APR05", '2017/01/25', 'true');

mysql> desc Offer;
+-----------------+-------------+------+-----+---------+-------+
| Field           | Type        | Null | Key | Default | Extra |
+-----------------+-------------+------+-----+---------+-------+
| CustomerOfferID | varchar(20) | NO   |     | NULL    |       |
| OfferNumber     | varchar(75) | NO   |     | NULL    |       |
| CustomerID      | varchar(75) | NO   |     | NULL    |       |
| EffectiveDate   | date        | NO   |     | NULL    |       |
| IsSynchronized  | varchar(20) | NO   |     | NULL    |       |
+-----------------+-------------+------+-----+---------+-------+
5 rows in set (0.01 sec)

mysql> select * from Offer;
+-----------------+-------------+------------+---------------+----------------+
| CustomerOfferID | OfferNumber | CustomerID | EffectiveDate | IsSynchronized |
+-----------------+-------------+------------+---------------+----------------+
| Offer1          | 23          | APR01      | 2011-01-25    | true           |
| Offer2          | 14          | APR02      | 2011-01-25    | false          |
| Offer3          | 1223        | APR03      | 2012-01-25    | false          |
| Offer4          | 1423        | APR04      | 2014-01-25    | true           |
| Offer5          | 12345       | APR05      | 2017-01-25    | true           |
+-----------------+-------------+------------+---------------+----------------+
5 rows in set (0.00 sec)

mysql> use springcustomer;
Database changed

mysql> show tables;
+--------------------------+
| Tables_in_springcustomer |
+--------------------------+
| customer                 |
| customeremail            |
| item                     |
| market                   |
| offer                    |
| vendor                   |
+--------------------------+
6 rows in set (0.00 sec)

mysql>
