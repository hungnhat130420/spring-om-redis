package com.om.redis.entity;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.Searchable;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Document
public class Person {

    @Id
    @Indexed
    private String id;

    // Indexed for exact text matching
    @Indexed @NonNull
    private String firstName;

    @Indexed @NonNull
    private String lastName;

    //Indexed for numeric matches
    @Indexed @NonNull
    private Integer age;

    //Indexed for Full Text matches
    @Searchable @NonNull
    private String personalStatement;

    //Indexed for Geo Filtering
    @Indexed @NonNull
    private Point homeLoc;

    // Nest indexed object
    @Indexed @NonNull
    private Address address;

    @Indexed @NonNull
    private Set<String> skills;
}