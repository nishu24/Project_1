CREATE DATABASE ers;
CREATE TABLE reimbursement_status(
status_id int primary key,
reimb_status varchar(10) not null
);
CREATE TABLE reimbursement_type(
reimb_type_id int primary key,
reimb_type varchar(10) not null
);
CREATE TABLE user_roles(
	role_id INT PRIMARY KEY,
	role varchar(10) not null
);
create table users(
	user_id int PRIMARY KEY,
	username VARCHAR(25) unique not null,
	password VARCHAR(25) not null,
	first_name VARCHAR(25),
	last_name VARCHAR(25),
	email VARCHAR(25) unique not null,
	role_id int not null, 
    FOREIGN KEY(role_id) references user_roles(role_id)
);
drop table reimbursement;
CREATE TABLE reimbursement(
reimb_id INT PRIMARY KEY,
amount DOUBLE,
DESCRIPTION VARCHAR(30),
reimb_author int,
status_id int,
reimb_type_id int,
FOREIGN KEY(reimb_author) references user_roles(role_id),
FOREIGN KEY(status_id) references reimbursement_status(status_id),
FOREIGN KEY(reimb_type_id) references reimbursement_type(reimb_type_id)
);

CREATE TABLE reimbursement(
reimb_id INT PRIMARY KEY,
amount DOUBLE,
DESCRIPTION VARCHAR(30),
status varchar(25),
reimb_author int,
reimb_type_id int,
user_id int,
FOREIGN KEY (user_id) REFERENCES users(user_id),
FOREIGN KEY(reimb_author) references user_roles(role_id),
FOREIGN KEY(reimb_type_id) references reimbursement_type(reimb_type_id)
);
-- <--- INSERTING DATA INTO THE TABLES --->
INSERT INTO user_roles (role_id, role) VALUES (1, 'Admin');
INSERT INTO user_roles (role_id, role) VALUES (2, 'Employee');

INSERT INTO users (user_id, username, password, first_name, last_name, email, role_id)
	VALUES (1,'ben2411', 'bEn@2411', 'Benjamin', 'Stokes', 'benstokes@outlook.com', 1);
INSERT INTO users (user_id, username, password, first_name, last_name, email, role_id)
	VALUES (2,'sanju2411', '$@nju@2411', 'Sanju', 'Samson', 'sanjusamson@outlook.com', 2);
INSERT INTO users (user_id, username, password, first_name, last_name, email, role_id)
	VALUES (3,'graeme2411', 'gR@eMe@2411', 'Graeme', 'Smith', 'graemesmith@outlook.com', 2);    

INSERT INTO reimbursement_type (reimb_type_id, reimb_type) VALUES (1,'Lodging');
INSERT INTO reimbursement_type (reimb_type_id, reimb_type) VALUES (2,'Travel');
INSERT INTO reimbursement_type (reimb_type_id, reimb_type) VALUES (3,'Food');
INSERT INTO reimbursement_type (reimb_type_id, reimb_type) VALUES (4,'Medical');

INSERT INTO reimbursement_status (status_id, reimb_status) VALUES (1,'PENDING');
INSERT INTO reimbursement_status (status_id, reimb_status) VALUES (2,'APPROVED');
INSERT INTO reimbursement_status (status_id, reimb_status) VALUES (3,'REJECTED');

INSERT INTO reimbursement (reimb_id,amount,description,status,reimb_author,reimb_type_id,user_id) VALUES
		(1,2524,'Expenses for Hotel','Pending',2,1,1);
INSERT INTO reimbursement (reimb_id,amount,description,status,reimb_author,reimb_type_id,user_id) VALUES
		(2,192323,'Petrol Expenses','Pending',2,4,2);
INSERT INTO reimbursement (reimb_id,amount,description,status,reimb_author,reimb_type_id,user_id) VALUES
		(5,13234,'Grocery Expenses','PENDING',2,4,3);

SELECT * FROM reimbursement_status;
SELECT * FROM reimbursement_type;
SELECT * FROM users;
SELECT * FROM user_roles;
SELECT * FROM reimbursement;
-- GRANT ALL PRIVILEGES ON ers to 'root' IDENTIFIED BY '123456';
 select
        reimb_id as reimb_id1_0_,
        amount as amount2_0_,
        description as descript3_0_,
        reimb_author as reimb_au4_0_,
        reimb_type_id as reimb_ty5_0_,
        status_id as status_i6_0_ 
    from
        reimbursement ;
select * from reimbursement where reimb_author = 2;
truncate reimbursement;
commit;
-- drop fk constraint on the reimb_status table, and add user_id as fk constraint on reimbursement table.
-- CHANGE reimbursement table fk on class file. drop status_id and add user_id ref users.