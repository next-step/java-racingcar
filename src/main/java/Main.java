import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int carNum = InputView.inputCarNum();
        final int tryNum = InputView.inputTryNum();

        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
        final RacingManager racingManager = new RacingManager(cars);

        ResultView.printTitle();
        for (int i = 0; i < tryNum; i++) {
            racingManager.play();
            ResultView.printResult(cars);
        }
    }
}
