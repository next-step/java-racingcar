package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String COMMA = ",";
    private static final String COLON = " : ";
    private static final String POSITION_MARK = "-";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String FINAL_WON_MESSAGE = " 가 최종 우승했습니다.";
    private static final String NEW_LINE = System.lineSeparator();

    private ResultView() {
    }

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE + NEW_LINE);
    }

    public static void printRacingCars(List<CarsDto> carsValues) {
        for (CarsDto carsValue : carsValues) {
            List<CarDto> values = carsValue.getValues();
            printCarsRound(values);
            System.out.println(NEW_LINE);
        }
    }

    public static void printWinner(List<Car> winnerValues) {
        List<String> winnerCarNames = winnerValues.stream().map(Car::getName).collect(Collectors.toList());
        System.out.println(NEW_LINE + String.join(COMMA, winnerCarNames).concat(FINAL_WON_MESSAGE));
    }

    private static void printCarsRound(List<CarDto> values) {
        for (CarDto value : values) {
            printCarPosition(value);
        }
    }

    private static void printCarPosition(CarDto value) {
        System.out.print(value.getName() + COLON);
        System.out.println(POSITION_MARK.repeat(value.getPosition()));
    }
}
