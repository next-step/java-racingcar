package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.WinnerCars;

import java.util.ArrayList;
import java.util.List;

import static racingcar.utils.Constants.*;
import static racingcar.utils.StringUtils.repeat;

public class ResultView{

    private static OutputChannel outputChannel = OutputChannel.createSystemOut();

    private ResultView() {}

    public static void printStartResult() {
        outputChannel.printLine("\n"+SAY_VIEW_RESULT);
    }

    public static void printCarsResult(List<List<Car>> carsList) {
        for (int i = 0 ; i < carsList.size() ; i++) {
            printCars(carsList.get(i));
            printEmptyLine();
        }
    }

    public static void printCars(List<Car> cars) {
        for (int i = 0; i < cars.size() ; i ++) {
            printPosition(cars.get(i));
        }
    }

    public static void printPosition(Car car) {
            StringBuilder printPosition = new StringBuilder();
            for (int j = 0; j < car.getPosition(); j++) {
                printPosition.append(PRINT_GO);
            }
            outputChannel.printLine(car.getCarName() + SAY_CAR_NAMES + printPosition);
//        outputChannel.printLine(car.getCarName() + SAY_CAR_NAMES + repeat(PRINT_GO, car.getPosition()));
    }
    public static void printEmptyLine() {
        outputChannel.printLine(EMPTY_LINE);
    }

    public static void printWinners(Cars cars) {outputChannel.printLine(cars.getWinnersNames() + SAY_WINNER_CARS_NAMES); }
}
