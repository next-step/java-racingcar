package racingCar.view;

import racingCar.domain.Car;
import java.util.List;

public class ResultViewRacingCar {

    private ResultViewRacingCar() {
    };

    public static void resultViewCarData(List<Car> cars) {
        System.out.println();
        System.out.println("실행결과");

        for (Car car : cars) {
            resultViewCarName(car);
            resultViewCarPosition(car);
        }

        System.out.println();
    }

    private static void resultViewCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    private static void resultViewCarPosition(Car car) {
        for (int i = 0; i < car.getPosition(); ++i) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void resultViewWinners(List<String> winners) {
        for (int i = 0; i < winners.size(); ++i) {
            resultViewWinners(winners, i);
        }

        System.out.print("가 최종 우승했습니다.");
        System.out.println();
    }

    private static void resultViewWinners(List<String> winners, int i) {
        if (i == 0) {
            System.out.print(winners.get(i));
            return;
        }
        System.out.print("," + winners.get(i));
    }
}
