package com.aayush.jobportal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobRequestDTO {

    private String title;
    private String company;
    private String location;
    private Double salary;
    private String description;
}