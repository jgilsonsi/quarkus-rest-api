package com.jgdev.model;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
@UserDefinition
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "nome")
    private String name;

    private String cpf;

    @Username
    private String username;

    @Password
    private String password;

    @Roles
    private String role;

    @JsonbTransient
    public Long getId() {
        return id;
    }

    @JsonbTransient
    public String getCpf() {
        return cpf;
    }

    @JsonbTransient
    public String getPassword() {
        return password;
    }
}
