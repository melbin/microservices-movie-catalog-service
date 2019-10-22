package sv.edu.uesocc.dto;

public class Movie {
	
	private String movieId;
	private String title;
	private String movieSummary;
	
	public Movie() {
	}
	
	public Movie(String movieId, String title, String movieSummary) {
		this.movieId = movieId;
		this.title = title;
		this.movieSummary = movieSummary;
	}
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMovieSummary() {
		return movieSummary;
	}
	public void setMovieSummary(String movieSummary) {
		this.movieSummary = movieSummary;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", movieSummary=" + movieSummary + "]";
	}
}
