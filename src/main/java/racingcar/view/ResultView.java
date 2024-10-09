package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {

    private static final String MOVE_UNIT = "-";

    public static void printCarMovement(Car car) {
        System.out.println(car.getName() + ": "
                + draw(car.currentPosition()));
    }

    private static String draw(int currentPosition) {
        StringBuilder draw = new StringBuilder();
        for (int i = 0; i < currentPosition; i++) {
            draw.append(MOVE_UNIT);
        }

        return draw.toString();
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(",", winners));

    }
}