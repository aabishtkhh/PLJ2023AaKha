package ch.noseryoung.GhibliMovieReviews.domain.exceptions;

public class MovieReviewExceptions extends Exception{

    public MovieReviewExceptions (String message){
        super(message);
    }

    public MovieReviewExceptions(){
        super();
    }
}