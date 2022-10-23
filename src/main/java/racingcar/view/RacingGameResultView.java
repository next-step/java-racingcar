package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class RacingGameResultView {

    private static final String LOCATION_PRINT_LETTER = "-";

    public static void printMessage() {
        System.out.println("실행 결과");
    }

    public static void printRacingCar(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println(LOCATION_PRINT_LETTER.repeat(car.getLocation()));
        }
    }

    public static void printWinner(List<Car> cars) {
        StringBuilder result = new StringBuilder();

        result.append(cars.get(0).getName());

        for (int i = 1; i < cars.size(); i++) {
            result.append(", ");
            result.append(cars.get(i).getName());
        }

        System.out.println(result + "가 최종 우승했습니다.");
    }
}
