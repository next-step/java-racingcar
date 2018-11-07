package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int numberofCars;
    private int numberofAttempts;
    private List<Car> cars;

    public RacingGame(int numberofCars, int numberofAttempts) {
        this.numberofCars = numberofCars;
        this.numberofAttempts = numberofAttempts;
    }

    public List<Car> playGame(int attempts) {
        cars = getCars();
        for (int i = 0; i < attempts; i++) {
            move();
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

    private void move(){
        for(Car car: cars){
            car.move(getRandomValue());
        }
    }
    private int getRandomValue() {
        return new Random().nextInt(10);
    }
}
