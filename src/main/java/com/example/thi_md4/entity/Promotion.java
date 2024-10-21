package com.example.thi_md4.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "promotions")
public class Promotion {
//    id bigint primary key auto_increment,
//    title varchar(255) unique not null,
//    start_time DATETIME NOT NULL,
//    end_time DATETIME NOT NULL,
//    discount DECIMAL(5, 2) NOT NULL,
//    details

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String title;
    private Date start_time;
    private Date end_time;
    private String discount;
    private String details;


}
