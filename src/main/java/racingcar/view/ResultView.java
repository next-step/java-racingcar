package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winners;

import java.util.List;

import static racingcar.Constants.*;
import static racingcar.domain.Cars.findWinners;
import static racingcar.domain.Winners.getWinnersNames;
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

    public static void printWinners(List<Car> cars) {outputChannel.printLine(getWinnersNames(findWinners(cars)) + SAY_WINNERS_NAMES); }
}
