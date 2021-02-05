package com.example.issuemanagmentproject.entity;

import com.example.issuemanagmentproject.dto.UserDto;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Data  // getter and setter
@NoArgsConstructor  // bos constructor
@AllArgsConstructor // dolu constructor
@ToString
@EqualsAndHashCode

public class Project extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_code",length = 400,unique = true)
    private String projectCode;

    @Column(name = "project_name",length = 400,unique = true)
    private String projectName;

    @Column(name = "project_manag_id",length = 400,nullable = false,unique = false)
    private Long project_manag_id;

    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User manager;






}
