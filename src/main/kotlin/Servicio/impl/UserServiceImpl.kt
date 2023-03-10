package Servicio.impl


import GenericServiceImpl
import Model.User
import Repositorio.UserRepository
import Servicio.API.UserServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserServiceAPI, GenericServiceImpl<User, Long>() {
    @Autowired
    lateinit var repositorio: UserRepository
    override val dao: CrudRepository<User, Long>
        get() = repositorio


    override fun getUserByNick(nick: String): User? {
        return if (!repositorio.findUsersByNickName(nick).isNullOrEmpty()) repositorio.findUsersByNickName(nick)?.first()
        else null
    }
    override fun getUsersByNickName(nick: String): List<User>? = repositorio.findUsersByNickName(nick)
    override fun deleteUsersByNickName(nick: String):Boolean {
        val user = getUserByNick(nick)
        return if (user!= null) {
            delete(user.id!!)
            true
        } else false

    }


    override fun insertUser(usuario: User): Boolean {
        return if (getUserByNick(usuario.nick)==null){
            insert(usuario)
            true
        } else false
    }
    override fun updateUser(nick: String, usuario: User):Boolean{
        val updatedUser = getUserByNick(nick)
        return if (updatedUser!=null){
            updatedUser.nick = usuario.nick
            updatedUser.email = usuario.email
            updatedUser.profilePicture = usuario.profilePicture
            insert(updatedUser)
            true
        } else false
    }

}