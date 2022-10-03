package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRacing {
    private List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.start();
    }

    private void start() {
        participateCars();
        int rounds = InputView.inputRounds();
        play(rounds);
    }

    private void play(int rounds) {
        ResultView.printResultTitle();
        for (int i = 1; i <= rounds; i++) {
            playRound();
            announceRoundResult(i);
        }

    }

    private void playRound() {
        for (Car car : cars) {
            car.run();
        }
    }

    private void participateCars() {
        List<String> carNames = generateCarNames();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void announceRoundResult(int round) {
        ResultView.printRound(round);
        for (Car car: cars) {
            ResultView.printDistance(car.getName(), car.getDistance());
        }
        ResultView.printNewLine();
    }

    private List<String> generateCarNames() {
        String names = InputView.inputCarNames();
        return Arrays.asList(names.split(","));
    }
}
