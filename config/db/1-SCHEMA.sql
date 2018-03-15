drop schema if exists `computer-database-db`;
  create schema if not exists `computer-database-db`;
  use `computer-database-db`;

  drop table if exists computer;
  drop table if exists company;

  create table company (
    ca_id                        bigint not null auto_increment,
    ca_name                      varchar(255),
    constraint pk_company primary key (ca_id))
  ;

  create table computer (
    cu_id                        bigint not null auto_increment,
    cu_name                      varchar(255) NOT NULL,
    cu_introduced                datetime NULL,
    cu_discontinued              datetime NULL,
    cu_ca_id                bigint default NULL,
    constraint pk_computer primary key (cu_id))
  ;

  alter table computer add constraint fk_computer_company_1 foreign key (cu_ca_id) references company (ca_id) on delete restrict on update restrict;
  create index ix_computer_company_1 on computer (cu_ca_id);
