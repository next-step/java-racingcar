package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.GameResult;

import java.util.List;

public class OutputView {

    private OutputView() {
        throw new AssertionError();
    }

    public static void printRaceStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCars(List<Car> cars) {
        cars.forEach(OutputView::printCar);
        System.out.println();
    }

    private static void printCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printResult(GameResult result) {
        StringBuilder sb = new StringBuilder();
        result.getWinnerNames()
                .forEach(name -> sb.append(name + ","));
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb + " 이(가) 최종 우승했습니다");
    }
}
