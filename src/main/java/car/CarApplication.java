package car;

import car.input.Count;
import car.input.InputForm;
import java.io.IOException;
import car.logic.CarRacing;
import car.logic.Cars;
import car.output.OutputView;
public class CarApplication {
    private static CarRacing carRacing;
    public static void run() throws IOException {
        InputForm.printName();
        String name = InputForm.enterCarName();
        InputForm.printCount();
        Count count = new Count(InputForm.enterCount());
        carRacing = new CarRacing(new Cars(name));
        OutputView.printResult();
        for (int i = 0; i < count.getTryCount(); i++) {
            OutputView.printEachRaceResult(carRacing.runRaceOnce());
        }
        OutputView.printEachRaceResult(carRacing.getRaceResult());
        OutputView.printWinner(carRacing.selectWinner());
    }
}