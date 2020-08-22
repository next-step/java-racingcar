package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

import static racingcar.Constants.*;
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
        outputChannel.printLine(repeat(PRINT_GO, car.getPosition()));
    }

    public static void printLine() {
        outputChannel.printLine(BLANK_LINE);
    }


}
