package Repositorio

import Model.Session
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface SessionRepository : CrudRepository<Session, Long> {
    fun findByDate(date: LocalDate): List<Session>
}