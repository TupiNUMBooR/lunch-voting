INSERT INTO USERS (ID, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES (1, 'user@gmail.com', 'User_First', 'User_Last', 'password'),
       (2, 'admin@javaops.ru', 'Admin_First', 'Admin_Last', 'admin');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);