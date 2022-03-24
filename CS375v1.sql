--  \i 'C:/Users/Marlon Miller/Desktop/SE2/Team-Purple/CS375v1.sql'
drop database if exists cs375v1;
create database cs375v1 encoding 'UTF-8';
\c cs375v1;

drop table if exists question;
create table question (
    id serial primary key,
    question_id int,
    id_evaluation int,
    text text,
    question_type varchar(2)
);

insert into question (id,question_id,id_evaluation,text,question_type) values
(1,1,1,'Level of Responsibility','L4'),
(2,2,1,'Level of Collaboration','L4'),
(3,3,1,'Where there contributions?','TF'),
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
    id_evaluation int,
    class_id int
);

insert into evaluation (id_evaluation,class_id) values
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

--Joining example of how classes connect to their appropriate
--evaluations
select a.class_name as Class, a.class_id as ClassID, b.id_evaluation as Evaluation 
from class a join evaluation b on b.class_id = a.class_id order by a.class_name;

select a.class_name as Class, b.id_evaluation, c.question_id, c.text from class a
join evaluation b on b.class_id = a.class_id
join question c on c.id_evaluation = b.id_evaluation 
order by a.class_name, b.id_evaluation, c.question_id;

select a.id,a.question_id,a.id_evaluation,a.text,a.question_type, b.choice from question a 
join choices b on a.question_type = b.question_type;