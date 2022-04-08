--  \i 'C:/Users/Marlon Miller/Desktop/SE2/Team-Purple/evaluation-project/src/resources/CS375v1.sql'
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

drop table if exists question;
create table question (
    id serial primary key,
    question_id int,
    evalid int,
    text text,
    question_type varchar(2)
);

insert into question (id,question_id,evalid,text,question_type) values
(1,1,1,'Level of Responsibility','L4'),
(2,2,1,'Level of Collaboration','L4'),
(3,3,1,'Were there contributions?','TF'),
(4,4,1,'Communicates Clearly?','MC'),
(5,1,2,'Motivation','L5'),
(6,2,2,'Team Community','L4'),
(7,3,2,'Doubts on Teammates','L3');

drop table if exists users;
create table users (
    bannerid int,
    name_ varchar(50),
    username varchar(10),
    acadstatus varchar(50)
);

insert into users (bannerid, name_, username, acadstatus) values
(100, 'Marlon Miller', 'mem19b', 'Student'),
(101, 'Miranda Hixson', 'mbh18b', 'Student'),
(102, 'Julio Lopez', 'jjl18b', 'Student'),
(103, 'Brent Reeves','mrblee','Teacher'),
(104, 'Alex Jackson','asj18a','Student'),
(105, 'Justin Raitz','jmr18c','Student'),
(106, 'Brett Hammot','bah20a','Student'),
(107,'Fischer Coburn', 'fwc17a', 'Student'),
(108,'Mitchel Mellrose','wmm18a','Student'),
(109,'Luis Ibarra','lai19a','Student'),
(110,'Christa Greenwood','cgg20a','Student'),
(111,'Megan Skeen','mfs18a','Student'),
(112,'Garrett Powell','gbp18a','Student');

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
(1,1,2,'C',5),
(1,1,2,'H',4),
(1,1,2,'I',3),
(1,1,2,'K',2),
(1,1,2,'E',1),
(1,1,3,'C',1),
(1,1,3,'H',2),
(1,1,3,'I',3),
(1,1,3,'K',4),
(1,1,3,'E',5);

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

select a.studentName, a.studentid, b.teamid
from student a 
left join teams b on b.student = a.student
order by a.studentName;


drop table if exists choices;
create table choices (
    id serial primary key,
    question_type varchar(2),
    choice varchar(2)
);

insert into choices (id, question_type, choice) values 
(1,'TF','T'),
(2,'TF','F'),

(3,'L4', '1'),
(4,'L4', '2'),
(5,'L4', '3'),
(6,'L4', '4'),

(7,'L5', '1'),
(8,'L5', '2'),
(9,'L5', '3'),
(10,'L5', '4'),
(11,'L5', '5');

-- set of evaluations per class
drop table if exists evaluation;
create table evaluation (
    evalid int,
    class_id int
);

insert into evaluation (evalid,class_id) values
(1,1001),
(2,1001),
(1,2002),
(2,2002);

drop table if exists class;
create table class (
    class_id int,
    class_name text
);

insert into class (class_id, class_name) values 
(1001,'Software Engineering II'),
(2002,'Programming Languages'),
(3003,'Advanced Bible'),
(4004,'2D Animation');

drop table if exists Section1;
create table Section1(
    subsentence VARCHAR(500),
    response_ VARCHAR(500)
);

insert into section1 (subsentence, response_) values
('Contributing to the Teams Work', 'Does more or higher-quality work than expected.'),
('Contributing to the Teams Work', 'Makes important contributions that improve the teams work.'),
('Contributing to the Teams Work', 'Helps teammates who are having difficulty completing their work.'),
('Contributing to the Teams Work', 'Demonstrates behaviors described immediately above and below'),
('Contributing to the Teams Work','Completes a fair share of the teams work with acceptable quality.'),
('Contributing to the Teams Work', 'Keeps commitments and completes assignments on time.'),
('Contributing to the Teams Work', 'Helps teammates who are having difficulty when it is easy or important.'),
('Contributing to the Teams Work', 'Demonstrates behaviors described immediately above and below.'),
('Contributing to the Teams Work', 'Does not do a fair share of the teams work. Delivers sloppy or incomplete work.'),
('Contributing to the Teams Work', 'Misses deadlines. Is late, unprepared, or absent for team meetings.'),
('Contributing to the Teams Work', 'Does not assist teammates. Quits if the work becomes difficult.');

drop table if exists section2;
create table section2 (
    subsentence VARCHAR(500),
    response VARCHAR(500)
);

insert into section2(subsentence, response) values 
('Interacting with Teammates','Asks for and shows an interest in teammates'' ideas and contributions. 
    Makes sure teammates stay informed and understand each other.
    Provides encouragement or enthusiasm to the team.
    Asks teammates for feedback and uses their suggestions to improve.'),
('Interacting with Teammates','Demonstrates behaviors described immediately above and below.'),
('Interacting with Teammates','Listens to teammates and respects their contributions.
    Communicates clearly. Shares information with teammates.
    Participates fully in team activities.
    Respects and responds to feedback from teammates.'),
('Interacting with Teammates','Demonstrates behaviors described immediately above and below.'),
('Interacting with Teammates','Interrupts, ignores, bosses, or makes fun of teammates.
    Takes actions that affect teammates without their input. Does not share information.
    Complains, makes excuses, or does not interact with teammates.
    Is defensive. Will not accept help or advice from teammates.'); 

drop table if exists section3;
create table section3 (
    subsentence VARCHAR(500),
    response VARCHAR(500)
);

insert into section3(subsentence, response) values 
('Keeping the Team on Track','Watches conditions affecting the team and monitors the team''s progress.
    Makes sure that teammates are making appropriate progress.
    Gives teammates specific, timely, and constructive feedback.'),
('Keeping the Team on Track','Demonstrates behaviors described immediately above and below.'),
('Keeping the Team on Track','Notices changes that influence the team''s success.
    Knows what everyone on the team should be doing and notices problems.
    Alerts teammates or suggests solutions when the team''s success is threatened.'),
('Keeping the Team on Track','Demonstrates behaviors described immediately above and below.'),
('Keeping the Team on Track','Is unaware of whether the team is meeting its goals.
    Does not pay attention to teammates'' progress.
    Avoids discussing team problems, even when they are obvious.');

drop table if exists section4;
create table section4 (
    subsentence VARCHAR(500),
    response VARCHAR(500)
);

insert into section4(subsentence, response) values 
('Expecting Quality','Motivates the team to do excellent work.
    Cares that the team does outstanding work, even if there is no additional reward.
    Believes that the team can do excellent work.'),
('Expecting Quality','Demonstrates behaviors described immediately above and below.'),
('Expecting Quality','Encourages the team to do good work that meets all requirements.
    Wants the team to perform well enough to earn all available rewards.
    Believes that the team can fully meet its responsibilities.'),
('Expecting Quality','Demonstrates behaviors described immediately above and below.'),
('Expecting Quality','Satisfied even if the team does not meet assigned standards.
    Wants the team to avoid work, even if it hurts the team.
    Doubts that the team can meet its requirements.');

drop table if exists section5;
create table section5 (
    subsentence VARCHAR(500),
    response VARCHAR(500)
);

insert into section5(subsentence, response) values 
('Having Related Knowledge, Skills, and Abilities','Demonstrates the knowledge, skills, and abilities to do excellent work.
    Acquires new knowledge or skills to improve the team''s performance.
    Able to perform the role of any team member if necessary.'),
('Having Related Knowledge, Skills, and Abilities','Demonstrates behaviors described immediately above and below.'),
('Having Related Knowledge, Skills, and Abilities','Demonstrates sufficient knowledge, skills, and abilities to contribute to the team''s work.
    Acquires knowledge or skills as needed to meet requirements.
    Able to perform some of the tasks normally done by other team members.'),
('Having Related Knowledge, Skills, and Abilities','Demonstrates behaviors described immediately above and below.'),
('Having Related Knowledge, Skills, and Abilities','Missing basic qualifications needed to be a member of the team.
    Unable or unwilling to develop knowledge or skills to contribute to the team.
    Unable to perform any of the duties of other team members.');

--Joining example of how classes connect to their appropriate
--evaluations

drop owned by mrblee;
drop user if exists mrblee;
create user mrblee with password 'purplewhite';
grant connect on database cs375v1 to mrblee;
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

select a.class_name as Class, a.class_id as ClassID, b.evalid as Evaluation 
from class a join evaluation b on b.class_id = a.class_id order by a.class_name;

select a.class_name as Class, b.evalid, c.question_id, c.text from class a
join evaluation b on b.class_id = a.class_id
join question c on c.evalid = b.evalid 
order by a.class_name, b.evalid, c.question_id;

select a.id,a.question_id,a.evalid,a.text,a.question_type, b.choice from question a 
join choices b on a.question_type = b.question_type;

SELECT * FROM Section1;

drop view if exists v_teams;
create view v_teams as 
select * from teams;

select * from v_teams;

drop view if exists v_response;
CREATE VIEW v_response AS
SELECT *
FROM response;

SELECT * FROM v_response; 

select student2, avg(value) from response group by student2;

select a.studentname, a.studentid, b.teamid from student a inner join teams b on b.student = a.student order by a.studentname;

select distinct a.studentname, a.studentid, teamid from student a
inner join teams b on b.student = a.student order by a.studentname;

select * from response;

create view v_response_team as select r.evalid as eval, r.student1 as s1, 
r.student2 as s2, r.category as cat, r.value as v, t.teamid as team
from response r
inner join teams t on (t.student = r.student1)
order by r.evalid, r.student1, r.student2, r.category;

select * from v_response_team order by eval, s1, s2, cat limit 20;

-- avg C for class
select cat, eval, team, count(v), avg(v) as avg from v_response_team where cat = 'C';

-- avg H for class
select cat, eval, team, count(v), avg(v) as avg from v_response_team where cat = 'H';

-- avg I for class
select cat, eval, team, count(v), avg(v) as avg from v_response_team where cat = 'I';

-- avg K for class
select cat, eval, team, count(v), avg(v) as avg from v_response_team where cat = 'K';

-- avg E for class
select cat, eval, team, count(v), avg(v) as avg from v_response_team where cat = 'E';

-- avg of student ratings including self
select eval, team, s2, count(v) n, avg(v) avg from v_response_team where team < 3 
group by eval, team, s2 order by team, s2;

-- avg of student ratings excluding self
select eval, team, s2, count(v) n, avg(v) avg from v_response_team where s1 != s2 
and team < 3 group by eval, team, s2 order by team, s2;

-- team 1
select eval, team, s2, count(v) n, avg(v) avg from v_response_team where team = 1 
group by eval, team, s2 order by team, s2;

-- Command in psql to read CVS file and insert into tables
-- copy response(evalid, student1, student2, category, value) from 'C:\Users\Marlon Miller\Desktop\SE2\Team-Purple\evaluation-project\src\resources\response.csv' delimiter ',' csv header;