import Model.Movie
import Servicio.impl.MovieServiceImpl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/movies")

class MoviesController {
    @Autowired
    lateinit var moviesService: MovieServiceImpl;

    @GetMapping()
    fun getAllMovies(): ResponseEntity<List<Movie>> {
        val movies = moviesService.all
        return if (movies != null) {
            ResponseEntity.ok(movies)
        } else {
            ResponseEntity.notFound().build()
        }
    }


    @GetMapping("/{id}")
    fun getMovieById(@PathVariable id: Long): ResponseEntity<Movie> {
        val movie = moviesService.dao.findById(id)
        return if (movie.isPresent) {
            ResponseEntity.ok(movie.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

}