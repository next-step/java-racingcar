package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.application.CarConstant.OUTPUT_CAR_WINNER_MESSAGE;

public class OutputView {

    public static void print() {
        System.out.println();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void carState(Car car) {
        StringBuilder result = new StringBuilder();
        if (car.getName() != null) {
            result.append(car.getName()).append(" : ");
        }
        for (int i = 0; i < car.getState().getState(); i++) {
            result.append("-");
        }
        print(result.toString());
    }

    public static void raceWinner(List<String> carNames) {
        print(String.join(", ", carNames) + OUTPUT_CAR_WINNER_MESSAGE);
    }
}
