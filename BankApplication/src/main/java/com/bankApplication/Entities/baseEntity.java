package com.bankApplication.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class baseEntity {
    @Id
    @GeneratedValue
    private Integer id;
}
