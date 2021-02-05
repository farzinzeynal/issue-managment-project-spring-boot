package com.example.issuemanagmentproject.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data  // getter and setter
@NoArgsConstructor  // bos constructor
@AllArgsConstructor // dolu constructor
@ToString
@EqualsAndHashCode

public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(name = "user_name",length = 100,unique = true)
    private  String username;

    @Column(name = "password",length = 200)
    private  String passWord;

    @Column(name = "sure_name",length = 200)
    private  String  sureName;

    @Column(name = "email",length = 200)
    private  String email;

/*    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> Issues;*/

}
