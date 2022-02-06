package racingcar;

import java.util.List;

public class OutputView {

    public static void printResult(List<Car> cars) {
        for (Car car: cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i).getName());
            if (i != (winners.size() - 1)) {
                winnerNames.append(", ");
            }
        }

        System.out.print("최종 우승자: ");
        System.out.println(winnerNames);
    }
}
