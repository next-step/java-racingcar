package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    public RacingGame(int carNumber, List<RacingCar> racingCarList) {
        for(int i=0; i<carNumber; i++) {
            racingCarList.add(new RacingCar());
        }
    }

    public void moveCars(List<RacingCar> racingCarList) {
        for (RacingCar car : racingCarList) {
            RacingRandom racingRandom = new RacingRandom();
            int power = racingRandom.getRandomNumber();
            car.move(power);
        }
    }
}

