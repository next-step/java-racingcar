package racingcar.view;

import racingcar.commons.Constant;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {
    public static void printCarRacingIntermediateState(List<Cars> carsList) {
        for (Cars cars : carsList) {
            System.out.println(getDashOnDistanceByCars(cars.getDistanceTraveled()));
        }
        System.out.print(Constant.LINE_DIVISION);
    }

    public static String getDashOnDistanceByCars(int movementDistance) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constant.MOVE_DISTANCE_MARK.repeat(Math.max(0, movementDistance)));
        return stringBuilder.toString();
    }
}
