package com.project.one.domain;

import com.project.one.domain.converters.StringListConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "physician")
public class Psychologist {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "mobile_verified")
    private Boolean mobileVerified;

    @Column(name = "gender")
    private String gender;

    @Column(name = "education")
    private String education;

    @Column(name = "experience")
    private String experience;

    @Column(name = "speciality")
    @Convert(converter = StringListConverter.class)
    private Set<String> speciality;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "resume")
    private String resume;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_active")
    private Boolean accountActive;

    @Column(name = "date_created")
    private String dateCreated;

    @Column(name = "language_known")
    @Convert(converter = StringListConverter.class)
    private Set<String> languagesKnown;

    @Column(name = "personal_message", columnDefinition = "LONGTEXT")
    private String personalMessage;

    @Column(name = "area_of_interest")
    @Convert(converter = StringListConverter.class)
    private Set<String> areaOfInterest;

    @Column(name = "counselling_methods")
    @Convert(converter = StringListConverter.class)
    private Set<String> counsellingMethods;

    @Column(name = "last_updated_at")
    private String lastUpdatedAt;

}
