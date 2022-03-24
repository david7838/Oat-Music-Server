create table student (
                         studentId int8 not null,
                         email_address varchar(255) not null,
                         firstName varchar(255),
                         lastName varchar(255),
                         email varchar(255),
                         mobile varchar(255),
                         name varchar(255),
                         primary key (studentId)
);

alter table student
    add constraint email_unique unique (email_address);

create sequence student_sequence;
