
package com.misiontic.sergio.cacharrero.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author Nico
 */

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name="user_email",unique=true,length =50,nullable =false)
    private String email;
//    @Column(name = "user_email", nullable = false, length = 50)
//    private String email;
    @NonNull
    @Column(name = "user_password", nullable = false, length = 50)
    private String password;
    @NonNull
    @Column(name = "user_name", nullable = false, length = 80)
    private String name;
}
