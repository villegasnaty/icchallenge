
    create table hibernate_sequence (
       next_val bigint
    ) engine=MyISAM

    insert into hibernate_sequence values ( 1 )

    create table player (
       id bigint not null,
        apellido varchar(255),
        edad varchar(255),
        fecha_de_nacimiento varchar(255),
        nombre varchar(255),
        primary key (id)
    ) engine=MyISAM
