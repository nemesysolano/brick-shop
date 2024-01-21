
create table SALES_PERSON (
	id bigint not null,
	name varchar(64) not null,
	ship_address_street varchar(128) not NULL,
	ship_address_city varchar(128) not NULL,
	ship_address_state varchar(128) not NULL,
	ship_address_country varchar(3) not NULL,
	ship_address_zip_code varchar(11) not null,
	phone_number VARCHAR(16)  NOT NULL,
	picture text not NULL,
	constraint custome_pk primary key (id)
);
