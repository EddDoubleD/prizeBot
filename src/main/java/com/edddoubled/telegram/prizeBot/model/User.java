package com.edddoubled.telegram.prizeBot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "company")
    private String company;

    @Column(name = "position")
    private String position;
    @Column(name = "phone")
    private String phone;
    @Column(name = "telegram")
    private String telegram;
}
