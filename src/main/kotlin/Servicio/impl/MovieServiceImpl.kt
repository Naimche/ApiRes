package Servicio.impl

import GenericServiceImpl
import Model.Movie
import Repositorio.MovieRepository
import Servicio.API.MovieServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl : MovieServiceAPI, GenericServiceImpl<Movie, Long>() {

    @Autowired
    lateinit var movie: MovieRepository
    override val dao: CrudRepository<Movie, Long>
        get() = movie
}