package racingcar;

import java.util.*;

public class RacingGame {
    public List<String> playRacing(Random random, List<Car> carList) {
        List<String> carMoveStatus = new ArrayList<>();

        for (Car car : carList) {
            int movableNum = random.nextInt(10);

            car.move(movableNum);
            carMoveStatus.add(car.getMoveRegex());
            System.out.println(car.getCarName() + " : " + car.getMoveRegex());
        }

        return carMoveStatus;
    }
}
