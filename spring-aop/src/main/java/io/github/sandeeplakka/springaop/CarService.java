package io.github.sandeeplakka.springaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class CarService implements ICarService {
    @Autowired
    @Qualifier("red")
    Car redCar;

    @Autowired
    @Qualifier("green")
    Car greenCar;

    public Car getRedCar() {
        return redCar;
    }

    public final List<Car> getCars() {
        return new ArrayList<Car>() {{
            add(getRedCar());
            add(getGreenCar());
        }};
    }

    public Car getGreenCar() {
        return greenCar;
    }
}
