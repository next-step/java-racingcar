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

    public static void printStartResult() {
        outputChannel.printLine("\n"+SAY_VIEW_RESULT);
    }

    public static void printCarsResult2(List<List<Car>> playCarsList) {
        for (int i = 0 ; i < playCarsList.size( ); i++) {
            for (int j = 0 ; j < playCarsList.get(i).size(); j++) {
                printPosition(playCarsList.get(i).get(j));
                System.out.println(playCarsList.get(i).get(j).getPosition());
            }
            printEmptyLine();
        }
    }

//        }

//    public static void printCarsResult(List<List<Car>> playCarsList) {
//        playCarsList.stream()
//                .forEach(ResultView::printCars);
//
//        }
//
//    public static void printCars(List<Car> cars) {
//       cars.stream()
//               .forEach(ResultView::printPosition);
//       printEmptyLine();
//    }

    public static void printPosition(Car car) {
            outputChannel.printLine(car.getCarName() + SAY_CAR_NAMES + repeat(PRINT_GO, car.getPosition()));
//        outputChannel.printLine(car.getCarName() + SAY_CAR_NAMES + repeat(PRINT_GO, car.getPosition()));
    }
    public static void printEmptyLine() {
        outputChannel.printLine(EMPTY_LINE);
    }

    public static void printWinners(Cars cars) {outputChannel.printLine(cars.getWinnersNames() + SAY_WINNER_CARS_NAMES); }
}
