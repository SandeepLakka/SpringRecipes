package io.github.sandeeplakka.springaop;

import java.util.List;

interface ICarService {
    Car getRedCar();

    Car getGreenCar();

    List<Car> getCars();
}
