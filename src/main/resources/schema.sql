CREATE TABLE CARS(
  ID INTEGER AUTO_INCREMENT PRIMARY KEY,
  CARPART VARCHAR(16) NOT NULL,
  WORKUNDERTAKEN VARCHAR(MAX) NOT NULL,
  HOURSPENT VARCHAR(10) NOT NULL,
  RESOULTIONCOMMENTS VARCHAR(100) NOT NULL
);