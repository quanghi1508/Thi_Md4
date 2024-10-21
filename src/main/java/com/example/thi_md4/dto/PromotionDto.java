package com.example.thi_md4.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PromotionDto {
    private Long id;
    private String title;
    private Date start_time;
    private Date end_time;
    private String discount;
    private String details;
}
