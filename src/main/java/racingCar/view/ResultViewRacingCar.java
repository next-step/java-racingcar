package racingCar.view;

import racingCar.domain.Car;
import racingCar.domain.CarStadium;

import java.util.List;

public class ResultViewRacingCar {

    private ResultViewRacingCar() {
    };

    public static void resultViewRacing() {
        System.out.println();
        System.out.println("실행결과");

        List<Car> cars = CarStadium.getCars();
        int rounds = CarStadium.getRounds();

        for (int i = 0; i < rounds; ++i) {
            resultViewCarData(cars);
        }

        resultViewWinners(cars);
    }

    private static void resultViewCarData(List<Car> cars) {
        for (Car car : cars) {
            resultViewCarName(car);
            resultViewCarDistance(car);
        }
        System.out.println();
    }

    private static void resultViewCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    private static void resultViewCarDistance(Car car) {
        CarStadium.moveCar(car);

        System.out.println(car.getPosition());
    }

    private static void resultViewWinners(List<Car> cars) {
        List<String> winners = CarStadium.getWinners(cars);

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
