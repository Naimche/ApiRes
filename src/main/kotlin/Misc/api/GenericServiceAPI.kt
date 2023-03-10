package Misc.api

import java.io.Serializable

interface GenericServiceAPI<T, ID: Serializable> {
    /**
     * Inserta un registro
     */
    fun insert(entity: T): T

    /**
     * Elimina un registro
     */
    fun delete(id: ID)

    /**
     * Obtiene un registro
     */
    operator fun get(id: ID): T?

    /**
     * Obtiene todos los registros
     */
    val all: MutableList<T>?
}