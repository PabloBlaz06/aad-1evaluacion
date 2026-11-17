package edu.iesam.aad_1evaluacion.feature.teslaSl.data.local.xml

import android.content.Context
import edu.iesam.aad_1evaluacion.R
import edu.iesam.aad_1evaluacion.feature.teslaSl.domain.Cars
import edu.iesam.aad_1evaluacion.feature.teslaSl.domain.Propietario
import edu.iesam.marvelapp.core.serialization.JsonSerializer
import kotlinx.serialization.serializer

class CarXmlLocalDataSource(
    private val context: Context,
    private val serializer: JsonSerializer<List<Cars>>,
    private val serializerp: JsonSerializer<List<Propietario>>
) {

    private val keyCars: String = "cars"
    private val keyPropietarios: String = "propietarios"
    private val ttl: Long = 2*60*1000

    val sharePref = context.getSharedPreferences(
        context.getString(R.string.local_source_vehiculo), Context.MODE_PRIVATE
    )

    fun saveCars(cars: List<Cars>){
        sharePref.edit().apply {
            putString(keyCars, serializer.toJson(cars))
            apply()
        }
    }

    fun findAllCars(): List<Cars>{
        val jsonList: String? = sharePref.getString(keyCars,null)
        jsonList?.let{
            return serializer.fromJson(it)
        }
        return emptyList()
    }

    fun findCarsByMatricula(matricula: String): Cars? {
        return findAllCars().find { it.matricula == matricula }
    }

    fun updateCar(cars: Cars){
        val car = findAllCars().filterNot { it.matricula == cars.matricula }.toMutableList()
        car.add(cars)
        saveCars(car)
    }

    fun deleteCar (matricula: String){
        saveCars(findAllCars().filterNot { it.matricula == matricula })
    }

    // funciones para propietarios

    fun savePropietario(propietarios : List<Propietario>){
        sharePref.edit().apply{
            putString(keyPropietarios, serializerp.toJson(propietarios))
            apply()
        }
    }

    fun findAllPropietarios(): List<Propietario>{
        val jsonList: String? = sharePref.getString(keyPropietarios, null)
        jsonList?.let{
            return serializerp.fromJson(it)
        }
        return emptyList()
    }

    fun findPropietarioByDni(dni: String): Propietario?{
        return findAllPropietarios().find { it.dni == dni }
    }

}