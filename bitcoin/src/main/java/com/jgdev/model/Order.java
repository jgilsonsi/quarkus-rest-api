package com.jgdev.model;

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
import java.time.LocalDateTime;

@Entity
@Table(name = "Ordem")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "preco")
    private Double value;

    @Column(name = "tipo")
    private String type;

    @Column(name = "data")
    private LocalDateTime date;

    private String status;

    @Column(name = "user_id")
    private Long userId;

    @JsonbTransient
    public Long getId() {
        return id;
    }

    @JsonbTransient
    public Long getUserId() {
        return userId;
    }
}
