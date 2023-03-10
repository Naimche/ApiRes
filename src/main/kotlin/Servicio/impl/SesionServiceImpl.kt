package Servicio.impl

import GenericServiceImpl
import Model.Session
import Repositorio.SessionRepository
import Servicio.API.SesionServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class SesionServiceImpl : SesionServiceAPI, GenericServiceImpl<Session, Long>() {

    @Autowired
    lateinit var session: SessionRepository
    override val dao: CrudRepository<Session, Long>
        get() = session


    override fun getTodaySessions(all: MutableList<Session>?): MutableList<Session> = session.findByDate(LocalDate.now())

    override fun getNextSessions(sessions: MutableList<Session>?): MutableList<Session> = session.findAll().filter { it.date.isAfter(LocalDate.now()) }.toMutableList()


    override fun getAllSessions(sessions: MutableList<Session>?): MutableList<Session> = session.findAll().toMutableList()
}