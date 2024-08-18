package com.user.repository;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_details")
public class UserDetailsEntity {

    @Id
    @Column(name = "user_id", nullable = false)
    private String userID;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;
}
