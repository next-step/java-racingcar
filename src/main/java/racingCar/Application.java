package racingCar;

import racingCar.controller.RacingController;
import racingCar.domain.MovementGenerator;
import racingCar.domain.RandomMovementGenerator;
import racingCar.view.InputView;
import racingCar.view.OutputView;
import racingCar.view.formatter.OutputFomatter;
import racingCar.view.printer.ConsolePrinter;
import racingCar.view.printer.Printer;
import racingCar.view.reader.ConsoleReader;
import racingCar.view.reader.Reader;

public class Application {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();
        InputView inputView = InputView.of(reader, printer);

        OutputFomatter outputFomatter = new OutputFomatter();
        OutputView outputView = new OutputView(printer, outputFomatter);

        MovementGenerator movementGenerator = new RandomMovementGenerator();
      
        RacingController racingController = new RacingController(inputView, outputView, movementGenerator);
        racingController.run();
    }
}
