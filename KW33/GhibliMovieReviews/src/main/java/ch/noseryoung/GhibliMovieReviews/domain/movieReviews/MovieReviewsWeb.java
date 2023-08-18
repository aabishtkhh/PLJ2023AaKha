package ch.noseryoung.GhibliMovieReviews.domain.movieReviews;

import ch.noseryoung.GhibliMovieReviews.domain.exceptions.MovieReviewExceptions;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@Log4j2
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:3000/")
public class MovieReviewsWeb {
    @Autowired
    private MovieReviewsService service;

    @GetMapping
    @Operation(summary = "Fetches all Movie Reviews", description = "When successful it fetches all reviews and returns a JSON-Code with the status code 200.")
    public ResponseEntity<List<MovieReviews>> allReviews (@RequestParam (value = "name", required = false) String filterName) {
        return ResponseEntity.ok().body(service.getAllReviews(filterName));
    }

    @GetMapping(value = "/{movieReviewId}")
    @Operation(summary = "Fetches the desired Review", description = "When successful it fetches the wished review and returns the JSON-Code with the status code 200.")
    public ResponseEntity<MovieReviews> singleReview (@PathVariable ("movieReviewId") Integer id) throws MovieReviewExceptions {
        return ResponseEntity.ok().body(service.getSingleReview(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('POST')")
    @Operation(summary = "Creates a Review", description = "When successful it creates a review with the wished values and returns the JSON-Code of created review with the status code 200.")
    public ResponseEntity<MovieReviews> createReviews (@Valid @RequestBody() MovieReviews reviews) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postAReview(reviews));
    }

    @PutMapping(value = "/{movieReviewId}")
    @PreAuthorize("hasAuthority('PUT')")
    @Operation(summary = "Updates the wished Review", description = "When successful it updates the review with the wished values and returns the JSON-Code of the updated review with the status code 200.")
    public ResponseEntity<MovieReviews> updateDrink(@Valid @PathVariable("movieReviewId")Integer id, @RequestBody MovieReviews reviews) throws MovieReviewExceptions {
        return ResponseEntity.status(200).body(service.putAReview(reviews, id));
    }

    @DeleteMapping(value = "/{movieReviewId}")
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Deletes the Review", description = "When successful it deletes the review with the status code 200.")
    public void deleteAReview(@Valid @PathVariable("movieReviewId") Integer id) {
        service.deleteAReview(id);
    }

    //exceptions:
    @ExceptionHandler(MovieReviewExceptions.class) //When ID doesn't exist
    public ResponseEntity<String> handlerNoSuchReviewException(MovieReviewExceptions re) {
        log.error("ID not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(re.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //When updating/ posting, everything has to be filled out
    public ResponseEntity<String> handlerNoNullReviewException(MethodArgumentNotValidException manve) {
        log.warn("Fill everything out");
        return ResponseEntity.status(400).body(Objects.requireNonNull(manve.getFieldError()).getDefaultMessage());
    }

}
