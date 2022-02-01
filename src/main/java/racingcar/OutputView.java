package racingcar;

import java.util.ArrayList;

public class OutputView {

    public static void printResult(ArrayList<Car> cars) {
        for (Car car: cars) {
            System.out.print(car.name + " : ");
            for (int i = 0; i < car.distance; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void printWinners(ArrayList<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i).name);
            if (i != (winners.size() - 1)) {
                winnerNames.append(", ");
            }
        }

        System.out.print("최종 우승자: ");
        System.out.println(winnerNames);
    }
}
