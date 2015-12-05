# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

<<<<<<< HEAD
create table product (
  ean                       varchar(255),
  name                      varchar(255),
  description               varchar(255))
;

create table user_info (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_user_info primary key (email))
;

create sequence user_info_seq;

=======
create table user (
  email                     varchar(255),
  password                  varchar(255),
  fullname                  varchar(255),
  is_admin                  boolean)
;

>>>>>>> c971860f60a9a899e2515115e56682ca0bbb74dc



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

<<<<<<< HEAD
drop table if exists product;

drop table if exists user_info;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists user_info_seq;

=======
drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

>>>>>>> c971860f60a9a899e2515115e56682ca0bbb74dc
