package carRacingWinner.repository;

import carRacingWinner.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerRepository {

    private List<Car> names;
    private int tryCount;

    public void makeCars(String[] words) {
        names = new ArrayList<>();
        for (String word : words) {
            names.add(new Car(word));
        }
    }

    public void tryCount(int tryCount) {
        this.tryCount = tryCount;
    }
}
