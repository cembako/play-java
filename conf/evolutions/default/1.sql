# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table city (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_city primary key (id))
;

create table pantauan (
  id                        integer not null,
  price                     float,
  constraint pk_pantauan primary key (id))
;

create table person (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_person primary key (id))
;

create table sembako (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_sembako primary key (id))
;

create table sembako_price (
  id                        integer not null,
  sembako_id                integer,
  price                     float,
  date                      timestamp,
  constraint pk_sembako_price primary key (id))
;

create table user (
  id                        integer not null,
  name                      varchar(255),
  fullname                  varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (id))
;

create table vote (
  id                        integer not null,
  score                     tinyint,
  constraint pk_vote primary key (id))
;

create sequence city_seq;

create sequence pantauan_seq;

create sequence person_seq;

create sequence sembako_seq;

create sequence sembako_price_seq;

create sequence user_seq;

create sequence vote_seq;

alter table sembako_price add constraint fk_sembako_price_sembako_1 foreign key (sembako_id) references sembako (id) on delete restrict on update restrict;
create index ix_sembako_price_sembako_1 on sembako_price (sembako_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists city;

drop table if exists pantauan;

drop table if exists person;

drop table if exists sembako;

drop table if exists sembako_price;

drop table if exists user;

drop table if exists vote;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists city_seq;

drop sequence if exists pantauan_seq;

drop sequence if exists person_seq;

drop sequence if exists sembako_seq;

drop sequence if exists sembako_price_seq;

drop sequence if exists user_seq;

drop sequence if exists vote_seq;

