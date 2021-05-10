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
            for (RacingCar car : racingCars) {
                RacingCar racingCar = new RacingCar(car.getCarName());
                int number = createRandomNumber();
                car.moveOrNot(number);
                System.out.println(car.getCarName()+" : "+racingCar.dash(car.getPosition()));
            }
            System.out.println();
        }
    }

    public void selectWinner(List<RacingCar> racingCars) {
        RacingCar racingCar = new RacingCar();
        for (int i = 0; i < racingCars.size(); i++) {
            if (racingCars[i] > maxlenth) {
                maxlenth = carNameArr[i].substring(carNameArr[i].indexOf(":") + 2, carNameArr[i].length()).length();
            }
        }
        for (int i = 0; i < carNameArr.length; i++) {
            if (maxlenth == carNameArr[i].substring(carNameArr[i].indexOf(":") + 2, carNameArr[i].length()).length()) {
                winnerList.add(carNameArr[i]);
            }
        }
        return winnerList;
    }
}
