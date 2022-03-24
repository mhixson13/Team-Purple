drop database if exists CS375v1;
create database CS375v1 encoding 'UTF-8';
\c CS375v1;

drop table if exists question;
create table question (
    id primary key,
    id_evaluation int,
    text text,
    question_type varchar(2)
);

insert into question (id,id_evaluation,text,question_type) values
(1,1,"Level of Responsibility","L4"),
(2,1,"Level of Collaboration","L4"),
(3,1,"Where there contributions?","TF"),
(4,1,"Communicates Clearly?","MC"),
(5,2,"Motivation","L5"),
(6,2,"Team Community","L4"),
(7,2,"Doubts on Teammates","L3");

drop table if exists choices_MC;
create table choices (
    id serial primary key,
    question_type varchar(2),
    choice text
);


-- set of evaluations per class
drop table if exists evaluation;
create table evaluation (
    id_evaluation int,
    class_id text
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
(1001,"Software Engineering II"),
(2002,"Programming Languages"),
(3003,"Advanced Bible"),
(4004,"2D Animation");

select a.class_name, a.class_id, b.class_id from class a 
join evaluation b on b.class_id = a.class_id order by a.class_name;