--create table user
--(
--    id integer not null,
--    name varchar(255) not null,
--    location varchar(255),
--    birth_date timestamp,
--    primary key(id)
--);

--insert into user(id, name, location, birth_date)
--values(10001, '스파이더맨', '뉴욕', sysdate());
--insert into user(id, name, location, birth_date)
--values(10002, '아이언맨', '뉴욕', sysdate());
--insert into user(id, name, location, birth_date)
--values(10003, '토르', '아스가르드', sysdate());

insert into course(id, name, created_date, last_updated_date)
 values(10001, 'JPA in 50 steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)
 values(10002, 'Spring in 50 steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)
 values(10003, 'Spring Boot in 100 steps', sysdate(), sysdate());