package racingcargame;

import java.util.List;

public class OutputView {

    private static final String MOVING_STATUS = "-";

    public void output(List<Car> racingOutput) {
        for (Car car : racingOutput) {
            System.out.println(MOVING_STATUS.repeat(car.getLocation()));
        }
        System.out.println();
    }
}
