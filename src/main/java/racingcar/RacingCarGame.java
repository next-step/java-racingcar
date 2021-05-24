package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {
    public final int moveNumber = 9;
    public Random random = new Random();

    public int createRandomNumber() {
        return random.nextInt(moveNumber);
    }

    public String advance(int position) {
        String bar = "";
        for (int i = 0; i < position; i++) {
            bar = bar.concat("-");
        }
        return bar;
    }

    public void startRacing(int count, RacingCars racingCars) {
        for (int i = 0; i < count; i++) {
            for (RacingCar car : racingCars.getRacingCars()) {
                int number = createRandomNumber();
                car.moveOrNot(number);
                System.out.println(car.getCarName() + " : " + this.advance(car.getPosition()));
            }
            System.out.println();
        }
    }

}
