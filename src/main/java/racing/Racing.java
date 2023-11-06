package racing;

import racing.car.Car;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private ParticipatingCars participatingCars;

    public Racing() {
        this.participatingCars = new ParticipatingCars();
    }

    public List<Car> ready(String[] inputNames) {
        for (int i = 0; i < inputNames.length; ++i) {
            participatingCars.join(new Car(inputNames[i]));
        }
        return this.participatingCars();
    }

    public List<Car> participatingCars() {
        return participatingCars.cars();
    }
}
