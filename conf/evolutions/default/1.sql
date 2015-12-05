# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tools (
  id                        bigint not null,
  name                      varchar(255),
  folder                    varchar(255),
  constraint pk_tools primary key (id))
;

create table user_info (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_user_info primary key (email))
;

create sequence tools_seq;

create sequence user_info_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists tools;

drop table if exists user_info;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists tools_seq;

drop sequence if exists user_info_seq;

