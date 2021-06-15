package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void showResult() {
        System.out.println("실행결과");
    }

    public static void cycleCarInformation(Cars cars) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            System.out.print(cars.getCars().get(i).getName() + " : ");
            showCarLocationInfo(cars.getCars().get(i).getLocation());
            System.out.println("");
        }
    }

    private static void showCarLocationInfo(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }

    public static void showWinner(List<Car> winnerNames) {
        String names = winnerNames.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.print("최종 우승자 : " + names);
    }
}
