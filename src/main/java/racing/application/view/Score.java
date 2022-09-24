package racing.application.view;

import java.util.List;
import racing.domain.car.Car;
import racing.domain.car.CarRace;

public class Score {

    private final List<CarRace> carRaces;

    public Score(List<CarRace> carRaces) {
        this.carRaces = carRaces;
    }

    public void print() {
        carRaces.forEach(carRace -> {
            carRace.cars().forEach(this::printCar);
            System.out.println();
        });
    }

    public int size() {
        return carRaces.size();
    }

    private void printCar(Car car) {
        String position = "-".repeat(car.position());
        System.out.printf("%s: %s\n", car.name(), position);
    }
}
