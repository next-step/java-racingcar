package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.WinnerCars;

import java.util.List;

import static racingcar.utils.Constants.*;
import static racingcar.utils.StringUtils.repeat;

public class ResultView{

    private static OutputChannel outputChannel;

    public ResultView(OutputChannel outputChannel) {
        this.outputChannel = outputChannel;
    }

    public static void printStartResult() {
        outputChannel.printLine("\n"+SAY_VIEW_RESULT);
    }

    public static void printCars(List<Car> cars) {
        cars.forEach(ResultView::printPosition);
    }

    public static void printPosition(Car car) {
        outputChannel.printLine(car.getCarName() + SAY_CAR_NAMES + repeat(PRINT_GO, car.getPosition()));
    }
    public static void printEmptyLine() {
        outputChannel.printLine(EMPTY_LINE);
    }

    public static void printWinners(String winnerCarsNames) {outputChannel.printLine(winnerCarsNames + SAY_WINNER_CARS_NAMES); }
}
