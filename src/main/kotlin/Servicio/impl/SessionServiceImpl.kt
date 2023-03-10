package Servicio.impl

import Model.Session
import Repositorio.SessionRepository
import Servicio.API.SessionServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import GenericServiceImpl as GenericServiceImpl1

@Service
class SessionServiceImpl : SessionServiceAPI, GenericServiceImpl1<Session, Long>() {

    @Autowired
    lateinit var session: SessionRepository
    override val dao: CrudRepository<Session, Long>
        get() = session

    override fun getSessionsByDate(date: LocalDate): List<Session> = session.findByDate(date)

    override fun getTodaySessions(all: List<Session>?): List<Session> = session.findByDate(LocalDate.now())

    override fun getFutureSessions(): List<Session> = session.findAll().filter { it.date.isAfter(LocalDate.now()) }

    override fun getPastSessions(): List<Session> = session.findAll().filter { it.date.isBefore(LocalDate.now())
    }
}