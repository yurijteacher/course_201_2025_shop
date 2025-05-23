create table categories
(
    id          bigint not null auto_increment,
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    primary key (id)
) engine =InnoDB;

create table customers
(
    id         bigint not null,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    phone      varchar(255),
    primary key (id)
) engine =InnoDB;

create table orders
(
    customer_id  bigint,
    date_created datetime(6),
    id           bigint not null auto_increment,
    delivery     varchar(255),
    payment      varchar(255),
    status       varchar(255),
    primary key (id)
) engine =InnoDB;

create table product_has_order
(
    quantity   smallint not null,
    id         bigint   not null auto_increment,
    order_id   bigint,
    product_id bigint,
    primary key (id)
) engine =InnoDB;

create table products
(
    price       decimal(38, 2),
    category_id bigint,
    id          bigint not null auto_increment,
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    primary key (id)
) engine =InnoDB;

create table roles
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine =InnoDB;

create table roles_userset
(
    roles_id   bigint not null,
    userset_id bigint not null,
    primary key (roles_id, userset_id)
) engine =InnoDB;

create table users
(
    id       bigint not null auto_increment,
    password varchar(255),
    username varchar(255),
    primary key (id)
) engine =InnoDB;

create table users_roleset
(
    roleset_id bigint not null,
    user_id    bigint not null,
    primary key (roleset_id, user_id)
) engine =InnoDB;

alter table customers
    add constraint FKpog72rpahj62h7nod9wwc28if foreign key (id) references users (id);
alter table orders
    add constraint FK_customer_id foreign key (customer_id) references customers (id);
alter table product_has_order
    add constraint FK_order_id foreign key (order_id) references orders (id);
alter table product_has_order
    add constraint FK_product_id foreign key (product_id) references products (id);
alter table products
    add constraint FKog2rp4qthbtt2lfyhfo32lsw9 foreign key (category_id) references categories (id);
alter table roles_userset
    add constraint FK4i7kn8dh2qj8mt963lxs5nyka foreign key (userset_id) references users (id);
alter table roles_userset
    add constraint FKluufmbvdoxalsicp8ry4x1xly foreign key (roles_id) references roles (id);
alter table users_roleset
    add constraint FK11w9oc7aarh6w64aoen8dcagi foreign key (roleset_id) references roles (id);
alter table users_roleset
    add constraint FK79r7w5wqcqg8piivydjo60v9s foreign key (user_id) references users (id);