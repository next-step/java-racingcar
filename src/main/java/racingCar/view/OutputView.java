package racingCar.view;

import java.util.List;
import racingCar.domain.Car;
import racingCar.domain.Cars;
import racingCar.view.formatter.OutputFomatter;
import racingCar.view.printer.Printer;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";
    private final Printer printer;
    private final OutputFomatter formatter;

    public OutputView(Printer printer, OutputFomatter formatter) {
        this.printer = printer;
        this.formatter = formatter;
    }

    public void printMovement(Cars cars) {
        cars.getCars().forEach(this::printEachCarMovement);
        printer.printEmptyLine();
    }

    private void printEachCarMovement(Car car) {
        String carName = formatter.toCarName(car);
        String movement = formatter.toMovement(car);

        printer.printLine("%s : %s", carName, movement);
    }

    public void printWinnerGroup(List<Car> winnerGroup) {
        String winners = formatter.toWinners(winnerGroup);

        printer.printLine("%s가 최종우승했습니다.", winners);
    }
}
