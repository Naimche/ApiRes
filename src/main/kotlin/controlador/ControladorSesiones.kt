package Servicio.API.controlador

import Model.Session
import Servicio.API.SesionServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/sessions")
class SessionsController {

    @Autowired
    lateinit var sesionService: SesionServiceAPI

    @GetMapping
    fun getAllSessions(): ResponseEntity<List<Session>> {
        val sessions = sesionService.getAllSessions(sesionService.all)
        return ResponseEntity.ok(sessions)
    }

    @GetMapping("/sincetoday")
    fun getSessionsSinceToday(): ResponseEntity<List<Session>> {
        val sessions = sesionService.getNextSessions(sesionService.all)
            return if (sessions.isNotEmpty()){
                ResponseEntity.ok(sessions)
            }else {
                ResponseEntity.notFound().build()
            }
    }

    @GetMapping("/today")
    fun getSessionsToday(): ResponseEntity<List<Session>> {
        val sessions = sesionService.getTodaySessions(sesionService.all)

            return if (sessions!!.isNotEmpty()){
                ResponseEntity.ok(sessions)
            }else {
                ResponseEntity.notFound().build()
            }

    }





}