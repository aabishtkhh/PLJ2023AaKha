package ch.noseryoung.GhibliMovieReviews.domain.movieReviews;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieReviewsRepository extends JpaRepository<MovieReviews, Integer> {
}
