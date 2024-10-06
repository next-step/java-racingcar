package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Garage;

import java.util.List;

public class ResultView {

    private static final String MOVE_UNIT = "-";

    public static void print(Garage garage) {
        for (Car car : garage.getCars()) {
            printCarMovement(car);
        }
        System.out.println();
    }

    private static void printCarMovement(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getMoveCount(); i++) {
            System.out.print(MOVE_UNIT);
        }
        System.out.println();
    }

    public static void printWinner(Garage garage) {

        StringBuilder winnerName = new StringBuilder();

        List<Car> winners = garage.findWinner();

        for (int i = 0; i < winners.size(); i++) {
            String name = winners.get(i).getName();

            if (i == winners.size() - 1) {
                winnerName.append(name);
                System.out.println(winnerName + "가 최종 우승했습니다.");
                return;
            }

            winnerName.append(name).append(",");
        }

    }
}
