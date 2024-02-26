CREATE TABLE IF NOT EXISTS GROUP (
  `BRAND_ID` int(10) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(15) NOT NULL
  PRIMARY KEY (`BRAND_ID`)
);

CREATE TABLE IF NOT EXISTS PRICES (
  `BRAND_ID` int(10),
  `START_DATE` datetime,
  `END_DATE` datetime,
  `PRICE_LIST` int(10),
  `PRODUCT_ID`int(10),
  `PRIORITY` tinyint,
  `PRICE` decimal(10,2) DEFAULT NULL,
  `CURR` enum('EUR','MXN')
  PRIMARY KEY (`ID_TERMINAL_LOTE`)
);