package ch.noseryoung.GhibliMovieReviews.domain.movieReviews;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/movieReview")
@CrossOrigin(origins = "http://localhost:3000/")
public class MovieReviewsWeb {
    @Autowired
    private MovieReviewsService service;

    // swagger + exceptions hinzufügen

    @GetMapping
    public ResponseEntity<List<MovieReviews>> allReviews (@RequestParam (value = "name", required = false) String filterName) {
        return ResponseEntity.ok().body(service.getAllReviews(filterName));
    }

    @GetMapping(value = "/{movieReviewId}")
    public ResponseEntity<MovieReviews> singleReview (@PathVariable ("movieReviewId") Integer id) {
        return ResponseEntity.ok().body(service.getSingleReview(id));
    }



}
