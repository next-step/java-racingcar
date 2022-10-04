package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String COMMA = ",";
    private static final String POSITION_MARK = "-";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String FINAL_WON_MESSAGE = " 가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void printResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE + "\n");
    }

    public static void printRacingCars(List<CarsDto> carsValues) {
        for (CarsDto carsValue : carsValues) {
            List<CarDto> values = carsValue.getValues();
            printCarsRound(values);
            System.out.println();
        }
    }

    public static void printWinner(List<Car> winnerValues) {
        System.out.println();
        List<String> winnerCarNames = winnerValues.stream().map(Car::getName).collect(Collectors.toList());
        System.out.print(String.join(COMMA, winnerCarNames));
        System.out.println(FINAL_WON_MESSAGE);
    }

    private static void printCarsRound(List<CarDto> values) {
        for (CarDto value : values) {
            System.out.print(value.getName() + " : ");
            printPositionMark(value.getPosition());
        }
    }

    private static void printPositionMark(int position) {
        System.out.println(POSITION_MARK.repeat(position));
    }
}
