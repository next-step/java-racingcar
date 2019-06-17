package carRacing;

import java.util.ArrayList;
import java.util.List;

public class RaceLap {

    private List<Car> cars;

    public RaceLap(Engine engine, int numberOfCars) {
        cars = new ArrayList<>();
        raceSetting(engine, numberOfCars);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void raceSetting(Engine engine, int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(engine));
        }
    }

    public RaceLap startRace() {
        for (Car car : cars) {
            car.move();
        }
        return this;
    }

    public RaceLap printRacingResult() {
        for (Car car : cars) {
            int movement = car.getMovement();
            chartPrint(movement);
        }
        System.out.println("\n");
        return this;
    }

    private void chartPrint(int movement) {
        for (int i = 0; i < movement; i++) {
            System.out.println("-");
        }
    }
}
