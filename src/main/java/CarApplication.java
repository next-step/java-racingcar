
import input.Count;
import input.InputForm;
import java.io.IOException;
import logic.CarRacing;
import logic.Cars;
import output.OutputView;
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