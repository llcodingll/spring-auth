package com.example.bank.account.domain;

import com.example.bank.pay.domain.Pay;
import com.example.bank.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(
        name = "ACCOUNTS"
)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer balance;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "account")
    private List<Pay> pays;
}
