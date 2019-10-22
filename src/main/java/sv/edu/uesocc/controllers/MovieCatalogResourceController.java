package sv.edu.uesocc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.edu.uesocc.dto.CatalogItem;
import sv.edu.uesocc.dto.CatalogItemList;
import sv.edu.uesocc.dto.Movie;
import sv.edu.uesocc.dto.Rating;
import sv.edu.uesocc.services.MovieInfoService;
import sv.edu.uesocc.services.RatingsInfoService;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResourceController {
	
	@Autowired
	private RatingsInfoService ratingsInfo;
	
	@Autowired
	private MovieInfoService movieInfo;
	
	@GetMapping("/{userId}")
	public CatalogItemList getCatalog(@PathVariable("userId") String userId){
		
		Rating[] ratingList = ratingsInfo.getUserRating(userId);
		List<CatalogItem> catalogItemList = new ArrayList<CatalogItem>();
		
		for(Rating rating : ratingList) {
			Movie movie = movieInfo.getUserMovie(rating);
			catalogItemList.add(new CatalogItem(movie.getTitle(),movie.getMovieSummary(),rating.getRating()));
		}
		
		return new CatalogItemList(catalogItemList);
	}
	
}
