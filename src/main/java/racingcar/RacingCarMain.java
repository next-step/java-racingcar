package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarMain {

    public static void main(String[] args) {
        int carNum = InputView.getCarNumber();
        int roundNum = InputView.getRoundNumber();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }

        Racing racing = new Racing(cars, roundNum);
        racing.start();
    }

}
