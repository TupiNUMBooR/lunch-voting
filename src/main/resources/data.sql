INSERT INTO USERS (ID, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES (100001, 'admin@lunchvoting.ru', 'Admin_First', 'Admin_Last', '{noop}admin'),
       (100002, 'user@gmail.com', 'User_First', 'User_Last', '{noop}password'),
       (100003, 'guest@gmail.com', 'Guest_First', 'Guest_Second', '{noop}password');

INSERT INTO USER_ROLE (USER_ID, ROLE)
VALUES (100001, 'ADMIN'),
       (100001, 'USER'),
       (100002, 'USER');

INSERT INTO RESTAURANT (ID, NAME)
VALUES (100011, 'RESTAURANT_1'),
       (100012, 'RESTAURANT_2');

INSERT INTO MEAL (RESTAURANT_ID, MEAL_DAY, NAME, PRICE)
VALUES (100011, '2001-01-01', 'Meal_1', 100),
       (100011, '2001-01-02', 'Meal_2', 150),
       (100012, '2001-01-01', 'Meal_3', 200);

INSERT INTO VOTE (USER_ID, VOTE_DAY, RESTAURANT_ID)
VALUES (100001, '2001-01-01', 100011),
       (100001, '2001-01-02', 100011),
       (100002, '2001-01-01', 100011),
       (100003, '2001-01-01', 100011)
