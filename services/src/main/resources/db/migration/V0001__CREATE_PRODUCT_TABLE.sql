create table product (
	id bigserial not null,
	name varchar(64) not null,
	onhand integer not null,
	picture text not NULL,
	price decimal(10,2) not null,
	constraint product_pk primary key(id)
);
