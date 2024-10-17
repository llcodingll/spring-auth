package com.example.bank.user.domain;

import com.example.bank.BankApplication;
import com.example.bank.account.domain.Account;
import com.example.bank.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(
        name = "USERS"
        ,indexes = {@Index(columnList = "email"),@Index(columnList = "username")}
)
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Account> accounts = new ArrayList<>();
}
