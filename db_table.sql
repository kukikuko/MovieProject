create table movie
(
    movieId     bigint       not null
        primary key,
    title       varchar(255) not null,
    openDate    date         not null,
    `rank`      int          not null,
    director    varchar(50)  not null,
    actor       varchar(255) not null,
    posterImg   varchar(255) not null,
    description text         null
);
     comment '영화';

create table payment
(
    paymentId     varchar(50)  not null comment '결제 번호'
        primary key,
    userId        bigint       null comment '사용자 번호',
    reservationId varchar(255) null comment '예매 번호',
    price         int          null comment '가격',
    discount      int          null comment '할인',
    totalPrice    int          null comment '총 가격',
    constraint payment_reservation_reservationId_fk
        foreign key (reservationId) references reservation (reservationId)
            on update cascade on delete cascade,
    constraint payment_user_id_fk
        foreign key (userId) references user (id)
            on update cascade on delete cascade
)
     comment '결제';

create table reservation
(
    reservationId     varchar(255) not null comment '예매 번호'
        primary key,
    userId            bigint       null comment '사용자 번호',
    seatId            varchar(3)   null comment '좌석 번호',
    showTimeId        varchar(36)  null comment '상영정보 번호',
    price             int          null comment '예매 가격',
    reservationStatus varchar(10)  null comment '예매 상황',
    constraint reservation_seat_seatId_fk
        foreign key (seatId) references seat (seatId)
            on update cascade on delete cascade,
    constraint reservation_showtime_showTimeId_fk
        foreign key (showTimeId) references showtime (showTimeId)
            on update cascade on delete cascade,
    constraint reservation_user_id_fk
        foreign key (userId) references user (id)
            on update cascade on delete cascade
)
    comment '예매';

create table screenroom
(
    roomId     int         not null comment '상영관 코드'
        primary key,
    showTimeId varchar(36) null comment '상영정보 번호',
    totalSeat  int         null comment '좌석 수',
    roomName   varchar(10) null comment '상영관 이름',
    constraint screenroom_showtime_showTimeId_fk
        foreign key (showTimeId) references showtime (showTimeId)
            on update cascade on delete cascade
)
    comment '상영관';

create table seat
(
    seatId varchar(3)  not null comment '좌석 번호'
        primary key,
    roomId int         null comment '상영관 코드',
    `row`  varchar(1)  null comment '행',
    number int         null comment '번호(열)',
    status varchar(10) null comment '상태',
    constraint seat_screenroom_roomId_fk
        foreign key (roomId) references screenroom (roomId)
            on update cascade on delete cascade
)
    comment '좌석';

create table showtime
(
    showTimeId varchar(36) not null comment '상영정보 번호'
        primary key,
    movieId    bigint      not null comment '영화 번호',
    showDate   date        not null comment '상영 날짜',
    showTime   time        not null comment '상영 시간',
    constraint showtime_movie_movieId_fk
        foreign key (movieId) references movie (movieId)
            on update cascade on delete cascade
)
    comment '상영시간';

create table user
(
    id          bigint auto_increment comment '회원 번호'
        primary key,
    userId      varchar(50) null comment '아이디',
    password    varchar(50) not null comment '비밀번호',
    userName    varchar(20) not null comment '이름',
    email       varchar(50) null comment '이메일',
    phoneNumber varchar(15) null comment '전화번호',
    role        varchar(5)  null comment '역할',
    grade       varchar(3)  null
)
    comment '회원';