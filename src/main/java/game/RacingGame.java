package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int numberofCars;
    private List<Car> cars;

    public RacingGame(int numberofCars) {
        this.numberofCars = numberofCars;
        cars = getCars();
    }

    public List<Car> playGame() {
        for(Car car: cars){
            car.move(getRandomValue());
        }
        return cars;
    }

    public List<Car> getCars() {
        cars = new ArrayList<>();
        for (int i = 0; i < numberofCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private int getRandomValue() {
        return new Random().nextInt(10);
    }
}
