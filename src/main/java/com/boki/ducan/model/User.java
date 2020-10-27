package com.boki.ducan.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id-user")
    private int userId;
    
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    
    private String password;
    
    @Column(name = "first-name", nullable = false)
    private String firstName;
    
    @Column(name = "last-name", nullable = false)
    private String lastName;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="roles-id-role", nullable=false)
    private Role role;
         
    @OneToMany (mappedBy = "users")
    private Cart cart;
    
}