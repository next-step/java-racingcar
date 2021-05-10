package racingcar;

import java.util.List;
import java.util.Random;

public class RacingCarGame {

    public int createRandomNumber() {
        int number = 0;
        Random random = new Random();
        number = random.nextInt(9);
        return number;
    }


    public void startRacing(int count, List<RacingCar> racingCars) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < racingCars.size(); j++) {
                int number = createRandomNumber();
                carNameArr[j] += moveOrNot(number);
                System.out.println(carNameArr[j]);
            }
            System.out.println();
        }
    }
}
