package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {
    List<RacingCar> racingCars = new ArrayList<>();
    public final int moveNumber = 9;
    public Random random = new Random();

    public void player(String[] carNames) {
        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar(carName);
            racingCars.add(racingCar);
        }
    }

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

    public void startRacing(int count, List<RacingCar> racingCars) {
        for (int i = 0; i < count; i++) {
            for (RacingCar car : racingCars) {
                int number = createRandomNumber();
                car.moveOrNot(number);
                System.out.println(car.getCarName() + " : " + this.advance(car.getPosition()));
            }
            System.out.println();
        }
    }

}
