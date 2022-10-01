package racing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.start();
    }

    private void start() {
        prepare();
        int rounds = InputView.inputRounds();
        ResultView.printResultTitle();
        play(rounds);
    }

    private void play(int rounds) {
        for (int i = 1; i <= rounds; i++) {
            playRound();
            announceResult(i);
        }
    }

    private void prepare() {
        participateCars();
    }

    private void playRound() {
        for (Car car : cars) {
            car.run();
        }
    }

    private void participateCars() {
        int carCount = InputView.inputCars();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void announceResult(int round) {
        ResultView.printRound(round);
        for (Car car: cars) {
            ResultView.printDistance(car.distance());
        }
        ResultView.printNewLine();
    }
}
