# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comments (
  user                      varchar(255),
  posted_at                 timestamp,
  content                   clob,
  post_ean                  varchar(255))
;

create table product (
  ean                       varchar(255) not null,
  name                      varchar(255),
  description               varchar(255),
  picture                   varbinary(255),
  constraint pk_product primary key (ean))
;

create table tag (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_tag primary key (id))
;

create table users (
  id                        bigint not null,
  username                  varchar(255),
  password_hash             varchar(255),
  constraint uq_users_username unique (username),
  constraint pk_users primary key (id))
;


create table product_tag (
  product_ean                    varchar(255) not null,
  tag_id                         integer not null,
  constraint pk_product_tag primary key (product_ean, tag_id))
;
create sequence product_seq;

create sequence tag_seq;

create sequence users_seq;

alter table comments add constraint fk_comments_post_1 foreign key (post_ean) references product (ean) on delete restrict on update restrict;
create index ix_comments_post_1 on comments (post_ean);



alter table product_tag add constraint fk_product_tag_product_01 foreign key (product_ean) references product (ean) on delete restrict on update restrict;

alter table product_tag add constraint fk_product_tag_tag_02 foreign key (tag_id) references tag (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists comments;

drop table if exists product;

drop table if exists product_tag;

drop table if exists tag;

drop table if exists users;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists product_seq;

drop sequence if exists tag_seq;

drop sequence if exists users_seq;

