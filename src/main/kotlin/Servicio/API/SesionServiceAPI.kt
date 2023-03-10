package Servicio.API

import Misc.api.GenericServiceAPI
import Model.Session
import java.time.LocalDate

interface SesionServiceAPI : GenericServiceAPI<Session, Long> {
    fun getTodaySessions(all: MutableList<Session>?): MutableList<Session>?
    fun getNextSessions(sessions: MutableList<Session>?): MutableList<Session>
    fun getAllSessions(sessions: MutableList<Session>?): MutableList<Session>
}