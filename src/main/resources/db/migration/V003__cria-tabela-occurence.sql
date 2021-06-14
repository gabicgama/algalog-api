create table occurrence (
	id bigint not null auto_increment,
    delivery_id bigint not null,
    description text not null,
    date_registry datetime not null,
    
    primary key (id)
);

alter table occurrence add constraint fk_occurrence_delivery
foreign key (delivery_id) references delivery (id);