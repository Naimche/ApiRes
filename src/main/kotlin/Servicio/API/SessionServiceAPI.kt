package Servicio.API

import Misc.api.GenericServiceAPI
import Model.Session
import java.time.LocalDate

interface SessionServiceAPI : GenericServiceAPI<Session, Long> {
    fun getSessionsByDate(date: LocalDate): List<Session>?
    fun getTodaySessions(all: List<Session>?): List<Session>?
    fun getFutureSessions(): List<Session>?
    fun getPastSessions(): List<Session>?
}