# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comments (
  user                      varchar(255),
  posted_at                 timestamp,
  content                   clob,
  post_id                   bigint)
;

create table product (
  id                        bigint not null,
  show                      bigint,
  ean                       varchar(255),
  name                      varchar(255),
  description               varchar(255),
  requested                 boolean,
  borrowed                  boolean,
  requestedby_id            bigint,
  borrow_id                 bigint,
  picture                   varbinary(255),
  constraint uq_product_requestedby_id unique (requestedby_id),
  constraint pk_product primary key (id))
;

create table users (
  id                        bigint not null,
  username                  varchar(255),
  password_hash             varchar(255),
  constraint uq_users_username unique (username),
  constraint pk_users primary key (id))
;

create sequence product_seq;

create sequence users_seq;

alter table comments add constraint fk_comments_post_1 foreign key (post_id) references product (id) on delete restrict on update restrict;
create index ix_comments_post_1 on comments (post_id);
alter table product add constraint fk_product_requestedby_2 foreign key (requestedby_id) references users (id) on delete restrict on update restrict;
create index ix_product_requestedby_2 on product (requestedby_id);
alter table product add constraint fk_product_borrow_3 foreign key (borrow_id) references users (id) on delete restrict on update restrict;
create index ix_product_borrow_3 on product (borrow_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists comments;

drop table if exists product;

drop table if exists users;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists product_seq;

drop sequence if exists users_seq;

