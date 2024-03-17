package racingcar.ui;

import racingcar.domain.*;

import java.text.MessageFormat;

public class ResultView {

    private static final String CAR_POSITION_STRING = "-";

    public static void printCarRaceResult(CarRaceResult carRaceResult) {
        System.out.println("실행 결과");
        System.out.println(getCarsPrintFormat(carRaceResult));
    }

    private static StringBuilder getCarsPrintFormat(CarRaceResult carRaceResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Cars cars : carRaceResult.get()) {
            appendCarsFormat(stringBuilder, cars);
        }
        return stringBuilder;
    }

    private static void appendCarsFormat(StringBuilder stringBuilder, Cars cars) {
        for (Car car : cars.get()) {
            stringBuilder.append(formatCar(car)).append(System.lineSeparator());
        }
        stringBuilder.append(System.lineSeparator());
    }

    private static String formatCar(Car car) {
        return MessageFormat.format("{0} : {1}"
                , car.getName().get(), CAR_POSITION_STRING.repeat(car.getDistance().get()));
    }

    public static void printWinnerNames(Winners winners) {
        System.out.println(MessageFormat.format("{0}가 최종 우승했습니다.", formatWinners(winners)));
    }

    private static String formatWinners(Winners winners) {
        return String.join(",", winners.getNameStrings());
    }
}
