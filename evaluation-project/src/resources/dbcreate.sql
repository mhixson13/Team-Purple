--  \i 'C:/Users/Marlon Miller/Desktop/SE2/Team-Purple/evaluation-project/src/resources/dbcreate.sql'
--  \i 'C:/SE2/Team-Purple/evaluation-project/src/resources/CS375v1.sql'

-- CS375v1 Database Property of Purple
-- Members: Marlon Miller, Julio Lopez, Miranda Hixson
-- Date: 3-24-2022
-- Project: Peer Evaluation UI

-- psql command to copy csv into database
-- make sure you run 'psql -U postgres' inside the Team-Purple directory
-- meaning '\Team-Purple> psql -U postgres'
--\copy response(evalid, student1, student2, category, value) from 'evaluation-project/src/resources/response.csv' delimiter ',' csv header;
--\copy teams(evalid, teamid, student) from 'evaluation-project/src/resources/teams.csv' delimiter ',' csv header;
--\c postgres
drop database if exists cs375v1;
create database cs375v1 encoding 'UTF-8';
\c cs375v1;

-- drop table if exists question;
-- create table question (
--     id serial primary key,
--     question_id int,
--     evalid int,
--     text text,
--     question_type varchar(2)
-- );

-- insert into question (id,question_id,evalid,text,question_type) values
-- (1,1,1,'Level of Responsibility','L4'),
-- (2,2,1,'Level of Collaboration','L4'),
-- (3,3,1,'Were there contributions?','TF'),
-- (4,4,1,'Communicates Clearly?','MC'),
-- (5,1,2,'Motivation','L5'),
-- (6,2,2,'Team Community','L4'),
-- (7,3,2,'Doubts on Teammates','L3');

-- drop table if exists users;
-- create table users (
--     bannerid int,
--     name_ varchar(50),
--     username varchar(10),
--     acadstatus varchar(50)
-- );

-- insert into users (bannerid, name_, username, acadstatus) values
-- (100, 'Marlon Miller', 'mem19b', 'Student'),
-- (101, 'Miranda Hixson', 'mbh18b', 'Student'),
-- (102, 'Julio Lopez', 'jjl18b', 'Student'),
-- (103, 'Brent Reeves','mrblee','Teacher'),
-- (104, 'Alex Jackson','asj18a','Student'),
-- (105, 'Justin Raitz','jmr18c','Student'),
-- (106, 'Brett Hammot','bah20a','Student'),
-- (107,'Fischer Coburn', 'fwc17a', 'Student'),
-- (108,'Mitchel Mellrose','wmm18a','Student'),
-- (109,'Luis Ibarra','lai19a','Student'),
-- (110,'Christa Greenwood','cgg20a','Student'),
-- (111,'Megan Skeen','mfs18a','Student'),
-- (112,'Garrett Powell','gbp18a','Student');

drop table teams cascade;
drop table if exists teams;
create table teams (
    evalid int,
    teamid int,
    student int
);

insert into teams (evalid,teamid,student) values
(1,1,1),
(1,1,2),
(1,1,3),
(1,2,4),
(1,2,5),
(1,2,6),
(1,3,7),
(1,3,8),
(1,3,9),
(2,1,2),
(2,1,3),
(2,1,4),
(2,2,5),
(2,2,6),
(2,2,7),
(2,3,8),
(2,3,9),
(2,3,10);

drop table response cascade;
drop table if exists response;
create table response (
    evalid int,
    student1 int,
    student2 int,
    category varchar(10),
    value int
);

insert into response (evalid, student1,student2,category,value) values 
(1,1,1,'C',3),
(1,1,1,'I',3),
(1,1,1,'K',3),
(1,1,1,'E',3),
(1,1,1,'H',3),
(1,1,2,'C',4),
(1,1,2,'I',4),
(1,1,2,'K',4),
(1,1,2,'E',4),
(1,1,2,'H',4),
(1,1,3,'C',5),
(1,1,3,'I',5),
(1,1,3,'K',5),
(1,1,3,'E',5),
(1,1,3,'H',5),
(1,2,1,'C',2),
(1,2,1,'I',3),
(1,2,1,'K',2),
(1,2,1,'E',3),
(1,2,1,'H',2),
(1,2,2,'C',4),
(1,2,2,'I',4),
(1,2,2,'K',4),
(1,2,2,'E',4),
(1,2,2,'H',4),
(1,2,3,'C',4),
(1,2,3,'I',4),
(1,2,3,'K',4),
(1,2,3,'E',4),
(1,2,3,'H',4),
(1,3,1,'C',3),
(1,3,1,'I',3),
(1,3,1,'K',3),
(1,3,1,'E',3),
(1,3,1,'H',4),
(1,3,2,'C',4),
(1,3,2,'I',4),
(1,3,2,'K',5),
(1,3,2,'E',4),
(1,3,2,'H',4),
(1,3,3,'C',5),
(1,3,3,'I',5),
(1,3,3,'K',5),
(1,3,3,'E',5),
(1,3,3,'H',5),
(1,4,4,'C',3),
(1,4,4,'I',4),
(1,4,4,'K',3),
(1,4,4,'E',4),
(1,4,4,'H',4),
(1,4,5,'C',2),
(1,4,5,'I',3),
(1,4,5,'K',2),
(1,4,5,'E',3),
(1,4,5,'H',3),
(1,4,6,'C',2),
(1,4,6,'I',2),
(1,4,6,'K',2),
(1,4,6,'E',3),
(1,4,6,'H',3),
(1,5,4,'C',3),
(1,5,4,'I',4),
(1,5,4,'K',3),
(1,5,4,'E',4),
(1,5,4,'H',4),
(1,5,5,'C',3),
(1,5,5,'I',4),
(1,5,5,'K',4),
(1,5,5,'E',3),
(1,5,5,'H',3),
(1,5,6,'C',2),
(1,5,6,'I',3),
(1,5,6,'K',3),
(1,5,6,'E',3),
(1,5,6,'H',2),
(1,6,4,'C',5),
(1,6,4,'I',2),
(1,6,4,'K',3),
(1,6,4,'E',3),
(1,6,4,'H',5),
(1,6,5,'C',5),
(1,6,5,'I',4),
(1,6,5,'K',5),
(1,6,5,'E',3),
(1,6,5,'H',5),
(1,6,6,'C',4),
(1,6,6,'I',3),
(1,6,6,'K',3),
(1,6,6,'E',3),
(1,6,6,'H',5),
(1,7,7,'C',3),
(1,7,7,'I',3),
(1,7,7,'K',5),
(1,7,7,'E',3),
(1,7,7,'H',3),
(1,7,8,'C',4),
(1,7,8,'I',5),
(1,7,8,'K',5),
(1,7,8,'E',5),
(1,7,8,'H',5),
(1,7,9,'C',2),
(1,7,9,'I',4),
(1,7,9,'K',2),
(1,7,9,'E',2),
(1,7,9,'H',2),
(1,8,7,'C',5),
(1,8,7,'I',3),
(1,8,7,'K',3),
(1,8,7,'E',3),
(1,8,7,'H',3),
(1,8,8,'C',5),
(1,8,8,'I',5),
(1,8,8,'K',5),
(1,8,8,'E',5),
(1,8,8,'H',5),
(1,8,9,'C',2),
(1,8,9,'I',4),
(1,8,9,'K',2),
(1,8,9,'E',2),
(1,8,9,'H',2),
(1,9,7,'C',4),
(1,9,7,'I',4),
(1,9,7,'K',4),
(1,9,7,'E',4),
(1,9,7,'H',4),
(1,9,8,'C',5),
(1,9,8,'I',5),
(1,9,8,'K',5),
(1,9,8,'E',5),
(1,9,8,'H',5),
(1,9,9,'C',5),
(1,9,9,'I',5),
(1,9,9,'K',5),
(1,9,9,'E',4),
(1,9,9,'H',4),
(1,10,10,'C',4),
(1,10,10,'I',5),
(1,10,10,'K',5),
(1,10,10,'E',4),
(1,10,10,'H',5),
(1,10,11,'C',3),
(1,10,11,'I',4),
(1,10,11,'K',4),
(1,10,11,'E',4),
(1,10,11,'H',4),
(1,10,12,'C',4),
(1,10,12,'I',3),
(1,10,12,'K',3),
(1,10,12,'E',5),
(1,10,12,'H',5),
(1,11,10,'C',5),
(1,11,10,'I',5),
(1,11,10,'K',5),
(1,11,10,'E',4),
(1,11,10,'H',5),
(1,11,11,'C',5),
(1,11,11,'I',3),
(1,11,11,'K',4),
(1,11,11,'E',4),
(1,11,11,'H',5),
(1,11,12,'C',5),
(1,11,12,'I',3),
(1,11,12,'K',5),
(1,11,12,'E',5),
(1,11,12,'H',5),
(1,12,10,'C',4),
(1,12,10,'I',5),
(1,12,10,'K',4),
(1,12,10,'E',4),
(1,12,10,'H',5),
(1,12,11,'C',2),
(1,12,11,'I',3),
(1,12,11,'K',3),
(1,12,11,'E',4),
(1,12,11,'H',3),
(1,12,12,'C',4),
(1,12,12,'I',3),
(1,12,12,'K',3),
(1,12,12,'E',3),
(1,12,12,'H',5),
(1,13,13,'C',4),
(1,13,13,'I',4),
(1,13,13,'K',4),
(1,13,13,'E',4),
(1,13,13,'H',5),
(1,13,14,'C',4),
(1,13,14,'I',3),
(1,13,14,'K',3),
(1,13,14,'E',5),
(1,13,14,'H',5),
(1,13,15,'C',4),
(1,13,15,'I',5),
(1,13,15,'K',4),
(1,13,15,'E',4),
(1,13,15,'H',4),
(1,14,13,'C',4),
(1,14,13,'I',4),
(1,14,13,'K',4),
(1,14,13,'E',4),
(1,14,13,'H',5),
(1,14,14,'C',5),
(1,14,14,'I',3),
(1,14,14,'K',5),
(1,14,14,'E',5),
(1,14,14,'H',5),
(1,14,15,'C',5),
(1,14,15,'I',5),
(1,14,15,'K',4),
(1,14,15,'E',4),
(1,14,15,'H',5),
(1,15,13,'C',4),
(1,15,13,'I',4),
(1,15,13,'K',4),
(1,15,13,'E',4),
(1,15,13,'H',5),
(1,15,14,'C',4),
(1,15,14,'I',3),
(1,15,14,'K',5),
(1,15,14,'E',5),
(1,15,14,'H',5),
(1,15,15,'C',4),
(1,15,15,'I',5),
(1,15,15,'K',4),
(1,15,15,'E',4),
(1,15,15,'H',4),
(1,16,16,'C',5),
(1,16,16,'I',5),
(1,16,16,'K',5),
(1,16,16,'E',5),
(1,16,16,'H',5),
(1,16,17,'C',5),
(1,16,17,'I',5),
(1,16,17,'K',5),
(1,16,17,'E',5),
(1,16,17,'H',5),
(1,17,16,'C',5),
(1,17,16,'I',5),
(1,17,16,'K',5),
(1,17,16,'E',5),
(1,17,16,'H',5),
(1,17,17,'C',4),
(1,17,17,'I',4),
(1,17,17,'K',4),
(1,17,17,'E',5),
(1,17,17,'H',4),
(1,18,18,'C',4),
(1,18,18,'I',5),
(1,18,18,'K',4),
(1,18,18,'E',4),
(1,18,18,'H',4),
(1,18,19,'C',4),
(1,18,19,'I',4),
(1,18,19,'K',4),
(1,18,19,'E',4),
(1,18,19,'H',3),
(1,19,18,'C',4),
(1,19,18,'I',5),
(1,19,18,'K',4),
(1,19,18,'E',4),
(1,19,18,'H',3),
(1,19,18,'C',3),
(1,19,18,'I',3),
(1,19,18,'K',3),
(1,19,18,'E',4),
(1,19,18,'H',3);

drop table if exists student;
create table student (
    studentid varchar(10),
    student int,
    studentName text
);

insert into student (studentid, student, studentName) values
('id01',1,'StudentA'),
('id02',2,'StudentB'),
('id03',3,'StudentC'),
('id04',4,'StudentD'),
('id05',5,'StudentE'),
('id06',6,'StudentF'),
('id07',7,'StudentG'),
('id08',8,'StudentH'),
('id09',9,'StudentI'),
('id10',10,'StudentJ'),
('id11',11,'StudentK'),
('id12',12,'StudentL'),
('id13',13,'StudentM'),
('id14',14,'StudentN'),
('id15',15,'StudentO'),
('id16',16,'StudentP'),
('id17',17,'StudentQ'),
('id18',18,'StudentR'),
('id19',19,'StudentS');

-- select a.studentname, a.studentid, b.teamid, c.category,c.value from student a 
-- inner join teams b on b.student = a.student 
-- inner join response c on c.student1 = a.student
-- order by a.studentname;

-- select a.studentName, a.studentid, b.teamid
-- from student a 
-- left join teams b on b.student = a.student
-- order by a.studentName;


-- drop table if exists choices;
-- create table choices (
--     id serial primary key,
--     question_type varchar(2),
--     choice varchar(2)
-- );

-- insert into choices (id, question_type, choice) values 
-- (1,'TF','T'),
-- (2,'TF','F'),

-- (3,'L4', '1'),
-- (4,'L4', '2'),
-- (5,'L4', '3'),
-- (6,'L4', '4'),

-- (7,'L5', '1'),
-- (8,'L5', '2'),
-- (9,'L5', '3'),
-- (10,'L5', '4'),
-- (11,'L5', '5');

-- -- set of evaluations per class
-- drop table if exists evaluation;
-- create table evaluation (
--     evalid int,
--     class_id int
-- );

-- insert into evaluation (evalid,class_id) values
-- (1,1001),
-- (2,1001),
-- (1,2002),
-- (2,2002);

-- drop table if exists class;
-- create table class (
--     class_id int,
--     class_name text
-- );

-- insert into class (class_id, class_name) values 
-- (1001,'Software Engineering II'),
-- (2002,'Programming Languages'),
-- (3003,'Advanced Bible'),
-- (4004,'2D Animation');

-- drop table if exists Section1;
-- create table Section1(
--     subsentence VARCHAR(500),
--     response_ VARCHAR(500)
-- );

-- insert into section1 (subsentence, response_) values
-- ('Contributing to the Teams Work', 'Does more or higher-quality work than expected.'),
-- ('Contributing to the Teams Work', 'Makes important contributions that improve the teams work.'),
-- ('Contributing to the Teams Work', 'Helps teammates who are having difficulty completing their work.'),
-- ('Contributing to the Teams Work', 'Demonstrates behaviors described immediately above and below'),
-- ('Contributing to the Teams Work','Completes a fair share of the teams work with acceptable quality.'),
-- ('Contributing to the Teams Work', 'Keeps commitments and completes assignments on time.'),
-- ('Contributing to the Teams Work', 'Helps teammates who are having difficulty when it is easy or important.'),
-- ('Contributing to the Teams Work', 'Demonstrates behaviors described immediately above and below.'),
-- ('Contributing to the Teams Work', 'Does not do a fair share of the teams work. Delivers sloppy or incomplete work.'),
-- ('Contributing to the Teams Work', 'Misses deadlines. Is late, unprepared, or absent for team meetings.'),
-- ('Contributing to the Teams Work', 'Does not assist teammates. Quits if the work becomes difficult.');

-- drop table if exists section2;
-- create table section2 (
--     subsentence VARCHAR(500),
--     response VARCHAR(500)
-- );

-- insert into section2(subsentence, response) values 
-- ('Interacting with Teammates','Asks for and shows an interest in teammates'' ideas and contributions. 
--     Makes sure teammates stay informed and understand each other.
--     Provides encouragement or enthusiasm to the team.
--     Asks teammates for feedback and uses their suggestions to improve.'),
-- ('Interacting with Teammates','Demonstrates behaviors described immediately above and below.'),
-- ('Interacting with Teammates','Listens to teammates and respects their contributions.
--     Communicates clearly. Shares information with teammates.
--     Participates fully in team activities.
--     Respects and responds to feedback from teammates.'),
-- ('Interacting with Teammates','Demonstrates behaviors described immediately above and below.'),
-- ('Interacting with Teammates','Interrupts, ignores, bosses, or makes fun of teammates.
--     Takes actions that affect teammates without their input. Does not share information.
--     Complains, makes excuses, or does not interact with teammates.
--     Is defensive. Will not accept help or advice from teammates.'); 

-- drop table if exists section3;
-- create table section3 (
--     subsentence VARCHAR(500),
--     response VARCHAR(500)
-- );

-- insert into section3(subsentence, response) values 
-- ('Keeping the Team on Track','Watches conditions affecting the team and monitors the team''s progress.
--     Makes sure that teammates are making appropriate progress.
--     Gives teammates specific, timely, and constructive feedback.'),
-- ('Keeping the Team on Track','Demonstrates behaviors described immediately above and below.'),
-- ('Keeping the Team on Track','Notices changes that influence the team''s success.
--     Knows what everyone on the team should be doing and notices problems.
--     Alerts teammates or suggests solutions when the team''s success is threatened.'),
-- ('Keeping the Team on Track','Demonstrates behaviors described immediately above and below.'),
-- ('Keeping the Team on Track','Is unaware of whether the team is meeting its goals.
--     Does not pay attention to teammates'' progress.
--     Avoids discussing team problems, even when they are obvious.');

-- drop table if exists section4;
-- create table section4 (
--     subsentence VARCHAR(500),
--     response VARCHAR(500)
-- );

-- insert into section4(subsentence, response) values 
-- ('Expecting Quality','Motivates the team to do excellent work.
--     Cares that the team does outstanding work, even if there is no additional reward.
--     Believes that the team can do excellent work.'),
-- ('Expecting Quality','Demonstrates behaviors described immediately above and below.'),
-- ('Expecting Quality','Encourages the team to do good work that meets all requirements.
--     Wants the team to perform well enough to earn all available rewards.
--     Believes that the team can fully meet its responsibilities.'),
-- ('Expecting Quality','Demonstrates behaviors described immediately above and below.'),
-- ('Expecting Quality','Satisfied even if the team does not meet assigned standards.
--     Wants the team to avoid work, even if it hurts the team.
--     Doubts that the team can meet its requirements.');

-- drop table if exists section5;
-- create table section5 (
--     subsentence VARCHAR(500),
--     response VARCHAR(500)
-- );

-- insert into section5(subsentence, response) values 
-- ('Having Related Knowledge, Skills, and Abilities','Demonstrates the knowledge, skills, and abilities to do excellent work.
--     Acquires new knowledge or skills to improve the team''s performance.
--     Able to perform the role of any team member if necessary.'),
-- ('Having Related Knowledge, Skills, and Abilities','Demonstrates behaviors described immediately above and below.'),
-- ('Having Related Knowledge, Skills, and Abilities','Demonstrates sufficient knowledge, skills, and abilities to contribute to the team''s work.
--     Acquires knowledge or skills as needed to meet requirements.
--     Able to perform some of the tasks normally done by other team members.'),
-- ('Having Related Knowledge, Skills, and Abilities','Demonstrates behaviors described immediately above and below.'),
-- ('Having Related Knowledge, Skills, and Abilities','Missing basic qualifications needed to be a member of the team.
--     Unable or unwilling to develop knowledge or skills to contribute to the team.
--     Unable to perform any of the duties of other team members.');

--Joining example of how classes connect to their appropriate
--evaluations

drop view if exists v_response_avg;
create view v_response_avg as
select distinct student1 as s1, student2 as s2, round(avg(value),2) as s1_avg from response 
group by student1, student2 order by student1;
select * from v_response_avg;

drop view if exists v_response_cat_avg;
create view v_response_cat_avg as
select student1 as s1, category as cat, round(avg(value),2) as s1_avg from response 
group by student1, category 
order by student1, category;
select * from v_response_cat_avg;

drop view if exists v_response_C;
create view v_response_C as
select * from v_response_cat_avg where cat like '%C%';
select * from v_response_C;

drop view if exists v_response_H;
create view v_response_H as
select * from v_response_cat_avg where cat like '%H%';
select * from v_response_H;

drop view if exists v_response_E;
create view v_response_E as
select * from v_response_cat_avg where cat like '%E%';
select * from v_response_E;

drop view if exists v_response_I;
create view v_response_I as
select * from v_response_cat_avg where cat like '%I%';
select * from v_response_I;

drop view if exists v_response_K;
create view v_response_K as
select * from v_response_cat_avg where cat like '%K%';
select * from v_response_K;

--drop owned by mrblee;
drop user if exists mrblee;
create user mrblee with password 'purplewhite';
grant connect on database cs375v1 to mrblee;
GRANT USAGE ON SCHEMA public TO mrblee;
alter user mrblee with SUPERUSER;

grant all on teams to mrblee;
grant all on response to mrblee;
grant all on student to mrblee;

grant all on v_response_avg to mrblee; -- starting here
grant all on v_response_cat_avg to mrblee;
grant all on v_response_C to mrblee;
grant all on v_response_H to mrblee;
grant all on v_response_E to mrblee;
grant all on v_response_I to mrblee;
grant all on v_response_K to mrblee;

grant select, update, delete on all tables in schema public to mrblee;

drop owned by mem19b;
drop user if exists mem19b;
create user mem19b with password 'mem19b';
grant connect on database cs375v1 to mem19b;
grant select, update, delete on all tables in schema public to mem19b;

drop owned by mbh18b;
drop user if exists mbh18b;
create user mbh18b with password 'mbh18b';
grant connect on database cs375v1 to mbh18b;
grant select, update, delete on all tables in schema public to mbh18b; 

drop owned by jjl18b;
drop user if exists jjl18b;
create user jjl18b with password 'jjl18b';
grant connect on database cs375v1 to jjl18b;
grant select, update, delete on all tables in schema public to jjl18b;

drop owned by asj18a;
drop user if exists asj18a;
create user asj18a with password 'asj18a';
grant connect on database cs375v1 to asj18a;
grant select, update, delete on all tables in schema public to asj18a;

drop owned by jmr18c;
drop user if exists jmr18c;
create user jmr18c with password 'jmr18c';
grant connect on database cs375v1 to jmr18c;
grant select, update, delete on all tables in schema public to jmr18c;

drop owned by bah20a;
drop user if exists bah20a;
create user bah20a with password 'bah20a';
grant connect on database cs375v1 to bah20a;
grant select, update, delete on all tables in schema public to bah20a;

drop owned by fwc17a;
drop user if exists fwc17a;
create user fwc17a with password 'fwc17a';
grant connect on database cs375v1 to fwc17a;
grant select, update, delete on all tables in schema public to fwc17a;

drop owned by wmm18a;
drop user if exists wmm18a;
create user wmm18a with password 'wmm18a';
grant connect on database cs375v1 to wmm18a;
grant select, update, delete on all tables in schema public to wmm18a;

drop owned by lai19a;
drop user if exists lai19a;
create user lai19a with password 'lai19a';
grant connect on database cs375v1 to lai19a;
grant select, update, delete on all tables in schema public to lai19a;

drop owned by cgg20a;
drop user if exists cgg20a;
create user cgg20a with password 'cgg20a';
grant connect on database cs375v1 to cgg20a;
grant select, update, delete on all tables in schema public to cgg20a;

drop owned by mfs18a;
drop user if exists mfs18a;
create user mfs18a with password 'mfs18a';
grant connect on database cs375v1 to mfs18a;
grant select, update, delete on all tables in schema public to mfs18a;

drop owned by gbp18a;
drop user if exists gbp18a;
create user gbp18a with password 'gbp18a';
grant connect on database cs375v1 to gbp18a;
grant select, update, delete on all tables in schema public to gbp18a;

--\copy response(evalid, student1, student2, category, value) from '../../resources/response.csv' delimiter ',' csv header;
--select * from response;
--\copy teams(evalid, teamid, student) from 'evaluation-project/src/resources/teams.csv' delimiter ',' csv header;

--\copy response(evalid, student1, student2, category, value) from '../../resources/response.csv' delimiter ',' csv header;
--\copy teams(evalid, teamid, student) from '../../resources/teams.csv' delimiter ',' csv header;

-- select a.class_name as Class, a.class_id as ClassID, b.evalid as Evaluation 
-- from class a join evaluation b on b.class_id = a.class_id order by a.class_name;

-- select a.class_name as Class, b.evalid, c.question_id, c.text from class a
-- join evaluation b on b.class_id = a.class_id
-- join question c on c.evalid = b.evalid 
-- order by a.class_name, b.evalid, c.question_id;

-- select a.id,a.question_id,a.evalid,a.text,a.question_type, b.choice from question a 
-- join choices b on a.question_type = b.question_type;

-- SELECT * FROM Section1;

-- drop view if exists v_teams;
-- create view v_teams as 
-- select * from teams;

-- select * from v_teams;

-- drop view if exists v_response;
-- CREATE VIEW v_response AS
-- SELECT *
-- FROM response;

-- SELECT * FROM v_response; 

-- select student2, avg(value) from response group by student2;

-- select a.studentname, a.studentid, b.teamid from student a inner join teams b on b.student = a.student order by a.studentname;

-- select distinct a.studentname, a.studentid, teamid from student a
-- inner join teams b on b.student = a.student order by a.studentname;

-- select * from response;

-- create view v_response_team as select r.evalid as eval, r.student1 as s1, 
-- r.student2 as s2, r.category as cat, r.value as v, t.teamid as team
-- from response r
-- inner join teams t on (t.student = r.student1)
-- order by r.evalid, r.student1, r.student2, r.category;

-- select * from v_response_team order by eval, s1, s2, cat limit 20;

-- -- avg C for class
-- select cat, eval, team, count(v), avg(v) as avg from v_response_team where cat = 'C' 
-- group by cat, eval, team;

-- -- avg H for class
-- select cat, eval, team, count(v), avg(v) as avg from v_response_team where cat = 'H'
-- group by cat, eval, team;

-- -- avg I for class
-- select cat, eval, team, count(v), avg(v) as avg from v_response_team where cat = 'I'
-- group by cat, eval, team;

-- -- avg K for class
-- select cat, eval, team, count(v), avg(v) as avg from v_response_team where cat = 'K'
-- group by cat, eval, team;

-- -- avg E for class
-- select cat, eval, team, count(v), avg(v) as avg from v_response_team where cat = 'E'
-- group by cat, eval, team;

-- -- avg of student ratings including self
-- select eval, team, s2, count(v) n, avg(v) avg from v_response_team where team < 3 
-- group by eval, team, s2 order by team, s2;

-- -- avg of student ratings excluding self
-- select eval, team, s2, count(v) n, avg(v) avg from v_response_team where s1 != s2 
-- and team < 3 group by eval, team, s2 order by team, s2;

-- -- team 1
-- select eval, team, s2, count(v) n, avg(v) avg from v_response_team where team = 1 
-- group by eval, team, s2 order by team, s2;

--  \i 'C:/Users/Marlon Miller/Desktop/SE2/Team-Purple/evaluation-project/src/resources/dbcreate.sql'
-- Command in psql to read CVS file and insert into tables
-- copy response(evalid, student1, student2, category, value) from 'C:\Users\Marlon Miller\Desktop\SE2\Team-Purple\evaluation-project\src\resources\response.csv' delimiter ',' csv header;