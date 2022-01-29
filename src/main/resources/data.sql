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

insert into passport(id, number)
 values(40001, 'A123456');
insert into passport(id, number)
 values(40002, 'B123456');
insert into passport(id, number)
 values(40003, 'C123456');

insert into student(id, name, passport_id)
 values(20001, 'Aaa', 40001);
insert into student(id, name, passport_id)
 values(20002, 'Bbb', 40002);
insert into student(id, name, passport_id)
 values(20003, 'Ccc', 40003);


insert into review(id, rating, description, course_id)
 values(50001, '5', 'great course', 10001);
insert into review(id, rating, description, course_id)
 values(50002, '4', 'good course', 10001);
insert into review(id, rating, description, course_id)
 values(50003, '3', 'okay course', 10003);

insert into student_course(student_id, course_id)
values(20001, 10001);
insert into student_course(student_id, course_id)
values(20002, 10001);
insert into student_course(student_id, course_id)
values(20003, 10001);
insert into student_course(student_id, course_id)
values(20001, 10003);