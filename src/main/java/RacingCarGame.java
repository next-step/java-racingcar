import service.Race;
import view.InputView;
import view.ResultView;

public class RacingCarGame {
    public static void main(String[] args) {
        Race race = new Race();
        String carsName = InputView.inputCarsName();
        int raceTryCount = InputView.inputRaceTryCount();

        ResultView.print(race.start(carsName, raceTryCount));
    }
}
