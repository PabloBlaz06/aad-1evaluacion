package edu.iesam.aad_1evaluacion.feature.teslaSl.data.local

import edu.iesam.aad_1evaluacion.feature.teslaSl.data.local.xml.CarXmlLocalDataSource
import edu.iesam.aad_1evaluacion.feature.teslaSl.domain.Cars
import edu.iesam.aad_1evaluacion.feature.teslaSl.domain.CarsRepository
import edu.iesam.aad_1evaluacion.feature.teslaSl.domain.Propietario

class CarsDataRepository (
    private val carXmlLocalDataSource: CarXmlLocalDataSource
): CarsRepository {
    override fun saveCars(cars: List<Cars>) {
        carXmlLocalDataSource.saveCars(cars)
    }

    override fun findAllCars(cars: List<Cars>) {
        carXmlLocalDataSource.findAllCars()
    }

    override fun findCarsByMatricula(matricula: String): Cars? {
        return carXmlLocalDataSource.findCarsByMatricula(matricula)
    }

    override fun updateCar(cars: Cars) {
        carXmlLocalDataSource.updateCar(cars)
    }

    override fun deleteCar(matricula: String) {
        carXmlLocalDataSource.deleteCar(matricula)
    }

    override fun savePropietario(propietarios: List<Propietario>) {
        carXmlLocalDataSource.savePropietario(propietarios)
    }

    override fun findAllPropietarios(): List<Propietario> {
        return carXmlLocalDataSource.findAllPropietarios()
    }

    override fun findPropietarioByDni(dni: String): Propietario? {
        return carXmlLocalDataSource.findPropietarioByDni(dni)
    }
}