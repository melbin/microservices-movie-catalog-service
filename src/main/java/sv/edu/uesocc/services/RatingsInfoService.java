package sv.edu.uesocc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import sv.edu.uesocc.dto.Rating;

@Service
public class RatingsInfoService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${ratins.data.service}")
	private String ratinsDataService;
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRating"
			,threadPoolKey = "ratingsInfoPool",
			threadPoolProperties = {
				@HystrixProperty(name = "coreSize", value = "20"),
				@HystrixProperty(name = "maxQueueSize", value = "10")
			}
			,commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value="5"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="50"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value="10000")
				}
			)
	public Rating[] getUserRating(String userId) {
		return restTemplate.getForObject(ratinsDataService+"/"+userId, Rating[].class);
	}
	
	public Rating[] getFallbackUserRating(String userId) {
		Rating rating = new Rating("0",0);
		Rating[] ratingArr = {rating};
		return ratingArr;
	}
	
}
