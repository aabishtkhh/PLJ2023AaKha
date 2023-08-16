package ch.noseryoung.GhibliMovieReviews.domain.role;

import ch.noseryoung.GhibliMovieReviews.domain.authority.Authority;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_role")
    private Integer roleId;
    @Column(name="name")
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_authorities",
            joinColumns = {
                    @JoinColumn(name = "id_role", referencedColumnName = "id_role"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_auth", referencedColumnName = "id_auth")
            }
    )
    private Set<Authority> roleAuth;
}
