import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.readCarNamesInput();
        int roundCount = InputView.readRoundCountInput();

        ResultView.printResultHeader();
        RaceController controller = new RaceController(carNames, roundCount);
        controller.start();
    }
}
