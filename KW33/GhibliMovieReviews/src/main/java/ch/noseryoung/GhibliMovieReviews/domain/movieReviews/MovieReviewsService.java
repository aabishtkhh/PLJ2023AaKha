package ch.noseryoung.GhibliMovieReviews.domain.movieReviews;

import ch.noseryoung.GhibliMovieReviews.domain.exceptions.MovieReviewExceptions;
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
        log.info("All reviews shown");
        List<MovieReviews> reviews;
        List<MovieReviews> filteredReviews = new ArrayList<>();
        reviews = repository.findAll();
        if (filterName != null){ //it checks if the reviews name is equal to the filteredName
            for (MovieReviews review : reviews) {
                if (review.getName().equals(filterName)){
                    filteredReviews.add(review); //when matches it adds to the filteredDrinks
                }
            }
            return filteredReviews;
        }else {
            return reviews;
        }
    }

    public MovieReviews getSingleReview(Integer id) throws MovieReviewExceptions {
        log.info(id + " review found");
        return repository.findById(id).orElseThrow(() -> new MovieReviewExceptions("ID "+ id +" not found"));
    }

    public MovieReviews postAReview(MovieReviews review) {
        log.info(review.getMovieReviewId() + "\nreview created");
        return repository.save(review);
    }

    public MovieReviews putAReview(MovieReviews review, Integer id) throws MovieReviewExceptions  {
        log.info(id + " review updated");
        if(repository.existsById(id)) {
            review.setMovieReviewId(id);
            return repository.save(review);
        }
        return repository.findById(id).orElseThrow(() -> new MovieReviewExceptions("ID "+ id +" not found"));
    }

    public void deleteAReview(Integer id) {
        log.info(id + " review deleted");
        repository.deleteById(id);
    }
}
