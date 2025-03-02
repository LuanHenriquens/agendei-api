create table if not exists `user` (
    `id` int not null auto_increment primary key,
    `name` varchar(50) unique,
    `email` varchar(50) unique,
    `password` varchar(400),
    `phone` varchar(11),
    `created_at` timestamp default current_timestamp,
    `updated_at` timestamp default current_timestamp on update current_timestamp,
    `active` boolean default true
);