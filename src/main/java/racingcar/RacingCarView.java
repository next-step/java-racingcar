package racingcar;

import java.util.List;

public class RacingCarView {

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

        for (int i = 0; i < cars.size(); i++) {
            result.append(cars.get(i).getName());
            generateComma(cars, result, i);
        }

        System.out.println(result + "가 최종 우승했습니다.");
    }

    private static void generateComma(List<Car> cars, StringBuilder result, int i) {
        if (i != cars.size()-1) {
            result.append(", ");
        }
    }
}
