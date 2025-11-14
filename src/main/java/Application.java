import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = InputView.readCarsInput();
        int roundCount = InputView.readRoundCountInput();

        ResultView.printResultHeader();
        RaceController controller = new RaceController(cars, roundCount);
        controller.start();
    }
}
