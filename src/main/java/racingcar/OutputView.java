package racingcar;

import java.util.List;

public class OutputView {

    public static void printPosition(RacingCar racingCar) {
        for (int i = 0; i < racingCar.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
