create database blog char set utf8mb4 collate utf8mb4_unicode_ci;

create table users(
	id int primary key auto_increment,
    first_name varchar(50) ,
    last_name varchar(50),
    password varchar (100),
    user_name varchar(50) not null
);

create table role(
	id int primary key auto_increment,
    description varchar(50) ,
    name varchar(50)
);

create table user_role(
	user_id int ,
    role_id int,
    constraint PK_user_role primary key (user_id,role_id),
    constraint FK_user foreign key (user_id) references users(id),
    constraint FK_role foreign key (role_id) references role(id)
);


create table comment(
	id int primary key auto_increment,
    content text,
    user_id int,
    constraint FK_comment_user foreign key (user_id) references users(id)
);

create table tag(
	id int primary key auto_increment,
    name varchar(50),
    user_id int,
    constraint FK_task_user foreign key (user_id) references users(id)
);

create table post(
	id int primary key auto_increment,
    title varchar(50) ,
    content text,
    user_id int,
    constraint FK_post_user foreign key (user_id) references users(id)
);

create table tag_post(
	tag_id int,
    post_id int,
    constraint PK_tag_post primary key (tag_id,post_id),
    constraint FK_tag foreign key (tag_id) references tag(id),
    constraint FK_post foreign key (post_id) references post(id)
);

