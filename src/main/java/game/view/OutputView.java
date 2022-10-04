package game.view;

import game.model.Car;
import game.model.Cars;
import utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String OUTPUT_SYMBOL = "-";
    private static final String OUTPUT_START_MESSAGE = "실행결과";
    private static final String OUTPUT_WINNER_SEPARATOR = ", ";
    private static final String OUTPUT_FINAL_MESSAGE = "가 최종 우승했습니다.";


    private OutputView() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void printOutputStart() {
        System.out.println();
        System.out.println(OUTPUT_START_MESSAGE);
    }

    public static void printOutputBody(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(getStringForOutput(car));
        }
        System.out.println();
    }

    private static String getStringForOutput(Car car) {
        return String.format("%s : %s", car.getCarName(), OUTPUT_SYMBOL.repeat(car.getPosition()));
    }

    public static void printOutputResult(Cars cars) {
        List<String> winners = cars.getLocatedHighPositionCars().stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
        System.out.println(StringUtils.join(winners, OUTPUT_WINNER_SEPARATOR) + OUTPUT_FINAL_MESSAGE);
    }

}
