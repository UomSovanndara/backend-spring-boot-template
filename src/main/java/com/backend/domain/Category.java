package com.backend.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    private Long   id;
    private String name;
    private Long   state;
    private String note;
    private Date   createdDate;
    private Long   createdByUserId;
    private Date   updatedDate;
    private Long   updatedByUserId;
}
