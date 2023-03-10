package Servicio.API

import Misc.api.GenericServiceAPI
import Model.User
import org.springframework.data.repository.CrudRepository

interface UserServiceAPI : GenericServiceAPI<User, Long> {
    fun getUserByNick (userName: String): User?
    fun getUsersByNickName (userName: String): List<User>?
    fun deleteUsersByNickName(userName: String):Boolean
    fun insertUser(user: User): Boolean
    fun updateUser(userName: String,user: User):Boolean

}