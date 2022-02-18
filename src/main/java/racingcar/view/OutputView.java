package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class OutputView {

    private OutputView() {
    }

    public static void printCurrentPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printfCarPosition(car);
            System.out.println();
        }
    }

    private static void printfCarPosition(Car car) {
        for (int j = 0; j < car.getPosition(); j++) {
            System.out.print("-");
        }
    }

    public static void printWinners(Race race) {
        System.out.print("최종 우승자: ");
        List<String> winnerNames = getWinnerNames(race.getCars(), race.getMaxScore());
        System.out.println(String.join(", ", winnerNames));
    }

    private static List<String> getWinnerNames(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSamePosition(maxPosition)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
