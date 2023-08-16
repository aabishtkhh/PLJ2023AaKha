package ch.noseryoung.GhibliMovieReviews.domain.movieReviews;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//or @Data
@Table(name = "movie-reviews")
public class MovieReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movieReviewId")
    private Integer drinkID;
    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "description")
    private String description;
    @Column(name = "length")
    private Double lengthOfMovie;
    @Column(name = "image_url")
    private String image_url;
}