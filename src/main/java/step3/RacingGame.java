package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private List<RacingCar> racingCarList = new ArrayList<>();

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public RacingGame(int carNumber) {
        for(int i=0; i<carNumber; i++) {
            racingCarList.add(new RacingCar());
        }
    }

    public void moveCars() {
        for (RacingCar car : racingCarList) {
            RacingRandom racingRandom = new RacingRandom();
            int power = racingRandom.getRandomNumber();
            car.move(power);
        }
    }
}

