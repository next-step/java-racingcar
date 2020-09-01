package racingcar.view;

import racingcar.domain.RaceResults;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.WinnerCars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.utils.Constants.*;
import static racingcar.utils.StringUtils.getNames;
import static racingcar.utils.StringUtils.repeat;

public class ResultView {

    private static OutputChannel outputChannel = OutputChannel.createSystemOut( );

    private ResultView() {
    }

    public static void printStartResult() {
        outputChannel.printLine("\n" + SAY_VIEW_RESULT);
    }

    public static void printRaceResult(List<Cars> carsList) {
        carsList.stream()
                .map(Cars::getCars)
                .forEach(ResultView::getCarListForNewLine);
    }

    private static void getCarListForNewLine(List<Car> carList) {
        carList.stream()
                .forEach(ResultView::printResultPerCar);
        printEmptyLine();
    }

    private static void printResultPerCar(Car car) {
           outputChannel.printLine(car.getCarName( ) + SAY_CAR_NAMES + repeat(PRINT_GO, car.getPosition( )));
       }

    public static void printEmptyLine() {
        outputChannel.printLine(EMPTY_LINE);
    }

    public static void printWinners(String winnerNames) {
        outputChannel.printLine(winnerNames + SAY_WINNER_CARS_NAMES);
    }



}
