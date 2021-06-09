package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingRandom;

import java.util.List;
import java.util.Objects;

public class ResultView {
    private static RacingRandom racingRandom = new RacingRandom();

    public static void showResult(Cars cars) {
        System.out.println("실행결과");
        for (int i = 0; i < cars.getCycle(); i++) {
            cycleCarInformation(cars.getCars());
        }
    }

    private static void cycleCarInformation(List<Car> carInfo) {
        for (int i = 0; i < carInfo.size(); i++) {
            carInfo.get(i).move(racingRandom.isMove());

            System.out.print(carInfo.get(i).getName() + " : ");
            showCarLocationInfo(carInfo.get(i).getLocation());
            System.out.println("");
        }
    }

    private static void showCarLocationInfo(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }

    public static void showWinner(List<Car> winnerNames) {
        System.out.print("최종 우승자 : ");
        winnerNames.stream().filter(Objects::nonNull).forEach(winner -> System.out.print(winner.getName()));
    }
}
