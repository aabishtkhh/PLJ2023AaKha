package ch.noseryoung.GhibliMovieReviews.domain.movieReviews;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class MovieReviewsService {
    @Autowired
    private MovieReviewsRepository repository;

    public List<MovieReviews> getAllReviews(String filterName) {
        return;
    }

    public MovieReviews getSingleReview(Integer id) {
        return;
    }

    public MovieReviews postADrink(MovieReviews drinks) {
        return;
    }

    public MovieReviews putADrink(MovieReviews drink, Integer id) {
        return;
    }

    public void deleteADrink(Integer id) {
    }
}
