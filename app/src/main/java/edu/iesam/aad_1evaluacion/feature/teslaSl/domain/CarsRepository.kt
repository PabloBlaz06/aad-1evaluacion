package edu.iesam.aad_1evaluacion.feature.teslaSl.domain

interface CarsRepository {
    fun saveCars(cars: List<Cars>)
    fun findAllCars(cars : List<Cars>)
    fun findCarsByMatricula(matricula: String): Cars?
    fun updateCar(cars: Cars)
    fun deleteCar (matricula: String)
    fun savePropietario(propietarios : List<Propietario>)
    fun findAllPropietarios(): List<Propietario>
    fun findPropietarioByDni(dni: String): Propietario?
}