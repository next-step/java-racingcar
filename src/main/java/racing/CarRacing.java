package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRacing {
    private List<Car> cars = new ArrayList<>();
    private int rounds = 0;

    public CarRacing(int carCount, int rounds) {
        setRace(carCount, rounds);
    }

    public int carsCount() {
        return cars.size();
    }

    public int rounds() {
        return rounds;
    }

    private void setRace(int carCount, int rounds) {
        participate(carCount);
        this.rounds = rounds;
    }

    private void participate(int carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }
}
