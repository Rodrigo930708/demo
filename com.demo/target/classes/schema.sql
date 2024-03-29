CREATE TABLE GROUPS (
BRAND_ID INT PRIMARY KEY,
DESCRIPTION VARCHAR(255));


CREATE TABLE IF NOT EXISTS PRICES (
  `BRAND_ID` int,
  `START_DATE` datetime,
  `END_DATE` datetime,
  `PRICE_LIST` int,
  `PRODUCT_ID`int,
  `PRIORITY` tinyint,
  `PRICE` decimal(10,2),
  `CURR` enum('EUR','MXN'),
FOREIGN KEY (`BRAND_ID`) REFERENCES `GROUPS`(`BRAND_ID`)
);