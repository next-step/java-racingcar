package carRacingWinner.repository;

import carRacingWinner.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerRepository {

    private List<Car> names;
    private int tryCount;
    private final String display = "-";

    public void makeCars(String[] words) {
        names = new ArrayList<>();
        for (String word : words) {
            names.add(new Car(word));
        }
    }

    public void tryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void currentLocation() {
        for (Car name : names) {
            showCar(name);
        }
        System.out.println();
    }

    private void showCar(Car car) {
        System.out.print(car.getName() + " ");
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print(display);
        }
    }


}
