package ch.noseryoung.GhibliMovieReviews.domain.role;

import ch.noseryoung.GhibliMovieReviews.domain.authority.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Authority, Integer> {
}
