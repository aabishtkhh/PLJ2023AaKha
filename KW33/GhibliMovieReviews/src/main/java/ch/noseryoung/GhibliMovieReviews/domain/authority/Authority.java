package ch.noseryoung.GhibliMovieReviews.domain.authority;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_auth")
    private Integer authId;
    @Column(name="name")
    private String authName;
}
