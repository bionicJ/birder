CREATE TABLE Users(
    userId VARCHAR(16) PRIMARY KEY NOT NULL,
    realName VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    located VARCHAR(255),
    isPrivate BOOLEAN,
    isVerified BOOLEAN
);
