package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
    public void play(int carCount, int excuteNumber) {
        Cars cars =  new Cars(createCars(carCount));
        for(int i=1; i<excuteNumber; i++){
            cars.moveCars();
            System.out.println();
        }
    }

    public List<Car> createCars(int number) {
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<number; i++){
            cars.add(new Car());
        }
        System.out.println();
        return cars;
    }
}
