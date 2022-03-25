--  \i 'C:/Users/Marlon Miller/Desktop/SE2/Team-Purple/CS375v1.sql'
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

drop table response cascade;
create table response(
    evalid int primary key, 
    student1 int, 
    student2 int, 
    category char(3), 
    value int
);

insert into response (evalid, student1, student2, category, value) values
(1,1,2,'POS',5),
(2,2,3,'NEU',3),
(3,3,4,'NEG',1);

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
select a.class_name as Class, a.class_id as ClassID, b.evalid as Evaluation 
from class a join evaluation b on b.class_id = a.class_id order by a.class_name;

select a.class_name as Class, b.evalid, c.question_id, c.text from class a
join evaluation b on b.class_id = a.class_id
join question c on c.evalid = b.evalid 
order by a.class_name, b.evalid, c.question_id;

select a.id,a.question_id,a.evalid,a.text,a.question_type, b.choice from question a 
join choices b on a.question_type = b.question_type;

SELECT * FROM Section1;

CREATE VIEW v_response AS
SELECT *
FROM response;

SELECT * FROM v_response;