import Misc.api.GenericServiceAPI
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.io.Serializable

@Service
abstract class GenericServiceImpl<T : Any, ID : Serializable> : GenericServiceAPI<T, ID> {

    override fun insert(entity: T): T {
        return dao.save(entity)
    }

    override fun delete(id: ID) {
        dao.deleteById(id)
    }

    override operator fun get(id: ID): T? {
        val obj = dao.findById(id)
        if (obj.isPresent) {
            return obj.get()
        }
        return null
    }

    override val all: MutableList<T>?
        get() {
            val returnList: MutableList<T> = mutableListOf()
            dao.findAll().forEach { entry: T -> returnList.add(entry) }
            return returnList
        }

    abstract val dao: CrudRepository<T, ID>
}