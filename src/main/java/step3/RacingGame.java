package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars = new ArrayList<>();
    private int tryTimes;

    public RacingGame() {
        // set new car
        int carsCnt = Input.setCarsCount();
        for (int i = 0; i < carsCnt; i++) {
            cars.add(new Car(i));
        }
        tryTimes = Input.setPlayCounts();
    }

    public void play() {

        Random random = new Random();
        System.out.println(tryTimes + 1 + " Try.. ");
        for (int i = 0; i < tryTimes; i++) {
            for (Car car : cars) {
                car.move();
                car.printCurrentLocation();
            }
        }


    }


}
