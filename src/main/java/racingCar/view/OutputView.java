package racingCar.view;

import racingCar.domain.Car;
import racingCar.domain.CarGroup;
import racingCar.domain.WinnerGroup;
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

    public void printMovement(CarGroup carGroup) {
        carGroup.getCarGroup().forEach(this::printEachCarMovement);
        printer.printEmptyLine();
    }

    private void printEachCarMovement(Car car) {
        String carName = formatter.toCarName(car);
        String movement = formatter.toMovement(car);
        printer.printLine("%s : %s", carName, movement);
    }

    public void printWinnerGroup(WinnerGroup winnerGroup) {
        String winners = formatter.toWinners(winnerGroup);
        printer.printLine("%s가 최종우승했습니다.", winners);
    }
}
