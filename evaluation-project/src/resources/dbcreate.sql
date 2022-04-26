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

drop table teams cascade;
drop table if exists teams;
create table teams (
    evalid int,
    teamid int,
    student int,
    unique(evalid,teamid,student)
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
(1,4,10),
(1,4,11),
(1,4,12),
(1,5,13),
(1,5,14),
(1,5,15),
(1,6,16),
(1,6,17),
(1,7,18),
(1,7,19);
-- (2,1,3),
-- (2,1,4),
-- (2,2,5),
-- (2,2,6),
-- (2,2,7),
-- (2,3,8),
-- (2,3,9),
-- (2,3,10);

drop table response cascade;
drop table if exists response;
create table response (
    evalid int,
    student1 int,
    student2 int,
    category varchar(10),
    value int,
    unique(evalid,student1,student2,category)
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
(1,19,19,'C',3),
(1,19,19,'I',3),
(1,19,19,'K',3),
(1,19,19,'E',4),
(1,19,19,'H',3);

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

drop view if exists v_response_avg;
create view v_response_avg as
select distinct student1 as s1, student2 as s2, round(avg(value),2) as s1_avg from response 
group by student1, student2 order by student1;
--select * from v_response_avg limit 10;

drop view if exists v_response_cat_avg;
create view v_response_cat_avg as
select student1 as s1, category as cat, round(avg(value),2) as s1_avg from response 
group by student1, category 
order by student1, category;
--select * from v_response_cat_avg limit 10;

drop view if exists v_response_C;
create view v_response_C as
select * from v_response_cat_avg where cat like '%C%';
--select * from v_response_C;

drop view if exists v_response_H;
create view v_response_H as
select * from v_response_cat_avg where cat like '%H%';
--select * from v_response_H;

drop view if exists v_response_E;
create view v_response_E as
select * from v_response_cat_avg where cat like '%E%';
--select * from v_response_E;

drop view if exists v_response_I;
create view v_response_I as
select * from v_response_cat_avg where cat like '%I%';
--select * from v_response_I;

drop view if exists v_response_K;
create view v_response_K as
select * from v_response_cat_avg where cat like '%K%';
--select * from v_response_K;

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

--------------------------------------------------------
-- Views:

drop view if exists v_extreme;
create view v_extreme as
select evalid, student1, category, round(avg(value),2),
case 
    when avg(value) = 5.0 or avg(value) = 1.0 then 'E'
    else 'NE'
end as EL
from response 
where student1 != student2 group by evalid,student1,category
order by evalid,student1,category;
 
drop view if exists v_general;
create view v_general as
with cte as (
    select evalid,student1,student2,category, value from response
    where category = 'C'
),

hte as (
    select evalid, student1,student2, category, value from response
    where category = 'H'
),

ite as (
    select evalid, student1,student2, category, value from response
    where category = 'I'
),

ete as (
    select evalid, student1,student2, category, value from response
    where category = 'E'
),

kte as (
    select evalid, student1,student2, category, value from response
    where category = 'K'
),

allC as (
    select cte.evalid,cte.student1 as Rator,cte.student2 as Ratee, cte.value as c, hte.value as h, ite.value as i, ete.value as e, kte.value as k
    from cte cte
    inner join hte hte on cte.evalid = hte.evalid and cte.student1 = hte.student1 and cte.student2 = hte.student2
    inner join ite ite on cte.evalid = ite.evalid and cte.student1 = ite.student1 and cte.student2 = ite.student2
    inner join ete ete on cte.evalid = ete.evalid and cte.student1 = ete.student1 and cte.student2 = ete.student2
    inner join kte kte on cte.evalid = kte.evalid and cte.student1 = kte.student1 and cte.student2 = kte.student2
)
select * from allC;
--select * from v_general;

drop view if exists v_table_names;
create view v_table_names as 
with rator as (
    select r.evalid, r.student1, s.studentname, r.student2, r.category, r.value from response r
    inner join student s on s.student = r.student1 order by r.evalid, r.student1, r.student2, r.category
),

ratee as (
   select r.evalid, r.student1, r.student2, s.studentname, r.category, r.value from response r
   inner join student s on s.student = r.student2 order by r.evalid, r.student1, r.student2, r.category
),

nameratings as (
    select response.evalid, rator.studentname as rator, ratee.studentname as ratee, response.category, response.value from response response
    inner join rator rator on rator.evalid = response.evalid and rator.student1 = response.student1 and rator.student2 = response.student2 
    and rator.category = response.category
    inner join ratee ratee on ratee.evalid = response.evalid and ratee.student1 = response.student1 and ratee.student2 = response.student2
    and ratee.category = response.category
)
select * from nameratings;

drop view if exists v_unanimous;
create view v_unanimous as
select evalid,
case 
    when rator != 'StudentA' then 'UNAN'
    else 'StudentA'
end as rator,
case
    when ratee != 'StudentA' then 'UNAN'
    else 'StudentA'
end as ratee, category, value
from v_table_names where rator = 'StudentA' or ratee = 'StudentA';

drop view if exists v_team_groups;
create view v_team_groups as 
with row_groups as (
    select *, 
    row_number() over(partition by teamid order by student) as row_number 
    from teams where evalid = 1
)
select * from row_groups;
--select * from v_team_groups;

drop view if exists v_general_two;
create view v_general_two as 
select *, row_number() over(partition by rator order by ratee) as row_number
from v_general;
--select * from v_general_two;

drop view if exists v_general_three;
create view v_general_three as
with rator1 as (
    select * from v_general_two where row_number = 1
),

rator2 as (
    select * from v_general_two where row_number = 2
),

rator3 as (
    select * from v_general_two where row_number = 3
),

allrator as (
    select rator1.evalid, rator1.rator, rator1.c as r1c, rator1.h as r1h, rator1.i as r1i, rator1.e as r1e, rator1.k as r1k,
    rator2.c as r2c, rator2.h as r2h, rator2.i as r2i, rator2.e as r2e, rator2.k as r2k,
    rator3.c as r3c, rator3.h as r3h, rator3.i as r3i, rator3.e as r3e, rator3.k as r3k
    from rator1 rator1
    join rator2 rator2 on rator2.evalid = rator1.evalid and rator2.rator = rator1.rator
    left join rator3 rator3 on rator3.evalid = rator1.evalid and rator3.rator = rator1.rator
    --join v_general_two v on v.rator = rator1.rator
)
select * from allrator;

drop view if exists v_general_table;
create view v_general_table as
select aa.evalid, aa.rator, bb.row_number as ratorNo, aa.r1c, aa.r1h, aa.r1i, aa.r1e, aa.r1k, aa.r2c, aa.r2h, aa.r2i, aa.r2e, aa.r2k, aa.r3c, aa.r3h, aa.r3i, aa.r3e, aa.r3k
from v_general_three aa 
inner join v_team_groups bb on bb.student = aa.rator;

-----------------------------------------
-----------------------------------------
-- Extreme Table
drop view if exists v_official_extreme;
create view v_official_extreme as
with extremeC as (
    select * from v_extreme where category = 'C'
),
extremeE as (
    select * from v_extreme where category = 'E'
),
extremeH as (
    select * from v_extreme where category = 'H'
),
extremeI as (
    select * from v_extreme where category = 'I'
),
extremeK as (
    select * from v_extreme where category = 'K'
),
allExtreme as (
    select extremeC.evalid, extremeC.student1, extremeC.el as C, extremeH.el as H, extremeE.el as E, extremeI.el as I, extremeK.el as K 
    from extremeC extremeC 
    inner join extremeE extremeE on extremeC.evalid = extremeE.evalid and extremeC.student1 = extremeE.student1
    inner join extremeH extremeH on extremeC.evalid = extremeH.evalid and extremeC.student1 = extremeH.student1
    inner join extremeI extremeI on extremeC.evalid = extremeI.evalid and extremeC.student1 = extremeI.student1
    inner join extremeK extremeK on extremeC.evalid = extremeK.evalid and extremeC.student1 = extremeK.student1
)
select * from allExtreme;
--select * from v_official_extreme;

drop view if exists v_avg_self;
create view v_avg_self as
select evalid, student1, avg(value) from response group by evalid, student1 order by evalid, student1;

drop view if exists v_avg_others;
create view v_avg_others as
select evalid, student1, avg(value) from response where student1 != student2 group by evalid, student1 order by evalid, student1;

drop view if exists v_standard_deviation_self;
create view v_standard_deviation_self as 
select evalid, student1, stddev(value) from response group by evalid, student1 order by evalid, student1;

drop view if exists v_standard_deviation_without_self;
create view v_standard_deviation_without_self as
select evalid, student1, stddev(value) from response where student1!= student2 group by evalid, student1 order by evalid, student1;

------- General Table

drop view if exists v_Official_general_avg;
create view v_Official_general_avg as
select gg.evalid, gg.rator, gg.ratorno, gg.r1c, gg.r1h, gg.r1i, gg.r1e, gg.r1k, gg.r2c, gg.r2h, gg.r2i, gg.r2e, gg.r2k, gg.r3c, gg.r3h, gg.r3i, gg.r3e, gg.r3k,
round(vas.avg,2) as avg_w_self, round(vao.avg,2) as avg_no_self, round(std1.stddev,3) as sd_w_self, round(std2.stddev,3) as sd_without_self 
from v_general_table gg
inner join v_avg_self vas on vas.evalid = gg.evalid and vas.student1 = gg.rator
inner join v_avg_others vao on vao.evalid = gg.evalid and vao.student1 = gg.rator
inner join v_standard_deviation_self std1 on std1.evalid = gg.evalid and std1.student1 = gg.rator
inner join v_standard_deviation_without_self std2 on std2.evalid = gg.evalid and std2.student1 = gg.rator;
--select * from v_Official_general_avg;

drop view if exists v_avg_and_std_cat;
create view v_avg_and_std_cat as
select evalid, student1, category, avg(value), stddev(value) from response group by evalid, student1, category order by evalid, student1, category;

drop view if exists v_official_std_cat;
create view v_official_std_cat as 
with stdc as (
    select * from v_avg_and_std_cat where category = 'C'
),
stde as (
    select * from v_avg_and_std_cat where category = 'E'
),
stdh as (
    select * from v_avg_and_std_cat where category = 'H'
),
stdi as (
    select * from v_avg_and_std_cat where category = 'I'
),
stdk as (
    select * from v_avg_and_std_cat where category = 'C'
),
allstd as (
    select stdc.evalid, stdc.student1, round(stdc.stddev,3) as C,round(stdh.stddev,3) as H, round(stde.stddev,3) as E, round(stdi.stddev,3) as I, round(stdk.stddev,3) as k
    from stdc stdc
    inner join stde stde on stde.evalid = stdc.evalid and stde.student1 = stdc.student1
    inner join stdh stdh on stdh.evalid = stdc.evalid and stdh.student1 = stdc.student1
    inner join stdi stdi on stdi.evalid = stdc.evalid and stdi.student1 = stdc.student1
    inner join stdk stdk on stdk.evalid = stdc.evalid and stdk.student1 = stdc.student1
)
select * from allstd;
--select * from v_official_std_cat;

select * from v_Official_general_avg;
select * from v_official_extreme;
select * from v_official_std_cat;

--drop view if exists json_official_general_avg;
drop view if exists v_json_extreme;
create view v_json_extreme as
select array_to_json(array_agg(t))
from (select * from v_official_extreme) t;
select * from v_json_extreme;
--\copy response(evalid, student1, student2, category, value) from '../../resources/response.csv' delimiter ',' csv header;
--\copy teams(evalid, teamid, student) from '../../resources/teams.csv' delimiter ',' csv header;
