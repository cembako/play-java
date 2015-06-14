# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cities (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_cities primary key (id))
;

create table pantauans (
  id                        integer not null,
  price                     float,
  sembako_id                integer,
  city_id                   integer,
  user_id                   bigint,
  constraint pk_pantauans primary key (id))
;

create table sembakos (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_sembakos primary key (id))
;

create table sembako_prices (
  id                        integer not null,
  sembako_id                integer,
  city_id                   integer,
  price                     float,
  date                      timestamp,
  constraint pk_sembako_prices primary key (id))
;

create table users (
  id                        bigint not null,
  name                      varchar(255),
  fullname                  varchar(255),
  password                  varchar(255),
  city_id                   integer,
  email                     varchar(255),
  constraint uq_users_name unique (name),
  constraint uq_users_email unique (email),
  constraint pk_users primary key (id))
;

create table votes (
  id                        bigint not null,
  score                     tinyint,
  constraint pk_votes primary key (id))
;

create sequence cities_seq;

create sequence pantauans_seq;

create sequence sembakos_seq;

create sequence sembako_prices_seq;

create sequence users_seq;

create sequence votes_seq;

alter table pantauans add constraint fk_pantauans_sembako_1 foreign key (sembako_id) references sembakos (id) on delete restrict on update restrict;
create index ix_pantauans_sembako_1 on pantauans (sembako_id);
alter table pantauans add constraint fk_pantauans_city_2 foreign key (city_id) references cities (id) on delete restrict on update restrict;
create index ix_pantauans_city_2 on pantauans (city_id);
alter table pantauans add constraint fk_pantauans_user_3 foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_pantauans_user_3 on pantauans (user_id);
alter table sembako_prices add constraint fk_sembako_prices_sembako_4 foreign key (sembako_id) references sembakos (id) on delete restrict on update restrict;
create index ix_sembako_prices_sembako_4 on sembako_prices (sembako_id);
alter table sembako_prices add constraint fk_sembako_prices_city_5 foreign key (city_id) references cities (id) on delete restrict on update restrict;
create index ix_sembako_prices_city_5 on sembako_prices (city_id);
alter table users add constraint fk_users_city_6 foreign key (city_id) references cities (id) on delete restrict on update restrict;
create index ix_users_city_6 on users (city_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists cities;

drop table if exists pantauans;

drop table if exists sembakos;

drop table if exists sembako_prices;

drop table if exists users;

drop table if exists votes;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists cities_seq;

drop sequence if exists pantauans_seq;

drop sequence if exists sembakos_seq;

drop sequence if exists sembako_prices_seq;

drop sequence if exists users_seq;

drop sequence if exists votes_seq;

