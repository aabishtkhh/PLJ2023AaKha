package ch.noseryoung.GhibliMovieReviews.domain.users;

import ch.noseryoung.GhibliMovieReviews.domain.role.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "restfood_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_Id")
    private Integer user_Id;
    @Column(name="name")
    private String userName;
    @Column(name="password")
    private String ps;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn (name = "user_Id", referencedColumnName = "user_Id"),
            inverseJoinColumns = @JoinColumn
                    (name = "id_role", referencedColumnName = "id_role")
    )
    private Role userRoles;

}