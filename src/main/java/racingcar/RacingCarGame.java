package racingcar;

import java.util.List;
import java.util.Random;

public class RacingCarGame {
    public int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }

    public String dashBar(int position) {
        String bar = "";
        for (int i = 0; i < position; i++) {
            bar = bar.concat("-");
        }
        return bar;
    }

    public void startRacing(int count, List<RacingCar> racingCars) {
        for (int i = 0; i < count; i++) {
            for (RacingCar car : racingCars) {
                RacingCar racingCar = new RacingCar(car.getCarName());
                int number = createRandomNumber();
                car.moveOrNot(number);
                System.out.println(car.getCarName() + " : " + this.dashBar(car.getPosition()));
            }
            System.out.println();
        }
    }

}
