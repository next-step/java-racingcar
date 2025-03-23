package domain;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void play(List<Integer> diceResults) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(diceResults.get(i));
        }
    }

    public int carCount() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }
}
