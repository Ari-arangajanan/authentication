package com.ari.AuthenticationAuthorization.model;

import lombok.Data;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String passWord;
    private boolean active;
    private String roles;

}
