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
            appendCars(stringBuilder, cars);
        }
        return stringBuilder;
    }

    private static void appendCars(StringBuilder stringBuilder, Cars cars) {
        for (Car car : cars.get()) {
            stringBuilder.append(getCarPrintFormat(car)).append("\n");
        }
        stringBuilder.append("\n");
    }

    private static String getCarPrintFormat(Car car) {
        return MessageFormat.format("{0} : {1}"
                , car.getName().get(), CAR_POSITION_STRING.repeat(car.getDistance().get()));
    }

    public static void printWinnerNames(Winners winners) {
        System.out.println(MessageFormat.format("{0}가 최종 우승했습니다.", winners.get()));
    }
}
