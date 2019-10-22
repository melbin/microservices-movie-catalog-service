package sv.edu.uesocc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import sv.edu.uesocc.dto.Movie;
import sv.edu.uesocc.dto.Rating;

@Service
public class MovieInfoService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${movie.info.service}")
	private String movieInfoService;
	
	@HystrixCommand(fallbackMethod = "fallbackUserMovie"
			,threadPoolKey = "movieInfoPool",
			threadPoolProperties = {
				@HystrixProperty(name = "coreSize", value = "20"),
				@HystrixProperty(name = "maxQueueSize", value = "10")
			}
			,commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value="10"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="50"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value="10000")
				}
			)
	public Movie getUserMovie(Rating rating) {
		return restTemplate.getForObject(movieInfoService+"/"+rating.getMovieId(), Movie.class);
	}
	
	public Movie fallbackUserMovie(Rating rating) {
		return new Movie(rating.getMovieId(),"Movie title not found","Movie summary not found");
	}
}
