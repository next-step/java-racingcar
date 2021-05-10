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

    public String dashbar(int position) {
        String dash = "";
            for (int i = 0; i < position; i++) {
                dash = dash.concat("-");
            }
        return dash;
    }

    public void startRacing(int count, List<RacingCar> racingCars) {
        for (int i = 0; i < count; i++) {
            for (RacingCar car : racingCars) {
                RacingCar racingCar = new RacingCar(car.getCarName());
                int number = createRandomNumber();
                car.moveOrNot(number);
                System.out.println(car.getCarName() + " : " + this.dashbar(car.getPosition()));
            }
            System.out.println();
        }
    }

}
