package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {

    private static final String MOVE_UNIT = "-";

    public static void print(List<Car> cars) {
        for (Car car : cars) {
            printCarMovement(car);
        }
        System.out.println();
    }

    private static void printCarMovement(Car car) {
        System.out.println(car.getName() + " : " + car.currentPosition().draw(MOVE_UNIT) );
    }

    public static void printWinner(List<Car> winners) {
        System.out.println(winnerName(winners) + "가 최종 우승했습니다.");
    }

    private static String winnerName(List<Car> winners) {
        StringBuilder winnerName = new StringBuilder(winners.get(0).getName());

        for (int i = 1; i < winners.size(); i++) {

            winnerName.append(",")
                    .append(winners.get(i).getName());

        }

        return winnerName.toString();
    }
}