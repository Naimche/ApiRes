package Misc.api

import java.io.Serializable

interface GenericServiceAPI<T, ID: Serializable> {

    fun insert(entity: T): T


    fun delete(id: ID)

    operator fun get(id: ID): T?

    val all: MutableList<T>?
}