package com.test_driven_development.entity;

import com.test_driven_development.enumeration.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    //    numéro de téléphone (unique, non null et valide pour un numéro de téléphone marocain)
    @Pattern(regexp = "(\\+212|1)(\\d){9}")
    @Column(name = "tel", nullable = false, unique = true)
    private String tel;



    @Column(name = "full_name", nullable = false)
    private String fullName;

    //    age (valide)

    @Column(name = "age", nullable = false)
    private int age;

    //    sex (valide, enumeration)
    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private SexEnum sex;


    //    isActive (boolean, default true)
    @Column(name = "is_active", nullable = false,columnDefinition="BOOLEAN DEFAULT 'true'")
    private Boolean isActive = false;

}
