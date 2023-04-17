import domain.game.RacingGame;
import domain.record.Records;
import view.InputView;
import view.PrintView;

public class CarRacing {

    public static void main(String[] args) {

        String[] nameOfCars = InputView.splitNameOfCars();
        int trial = InputView.trial();

        RacingGame game = new RacingGame(nameOfCars);
        Records records = game.start(trial);

        PrintView.printResult(records, trial);
    }
}
