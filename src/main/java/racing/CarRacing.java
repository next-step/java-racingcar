package racing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private int rounds = 0;
    private List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.play();
    }

    private void play() {
        prepare();
        for (int i = 1; i <= rounds; i++) {
            playRound();
            announceResult(i);
        }
    }

    private void prepare() {
        participateCars();
        setRounds();
    }

    private void playRound() {
        for (Car car : cars) {
            car.run();
        }
    }

    private void setRounds() {
        this.rounds = InputView.inputRounds();
    }

    private void participateCars() {
        int carCount = InputView.inputCars();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void announceResult(int round) {
        if (round == 1) ResultView.printResult();
        ResultView.printRound(round);
        for (Car car: cars) {
           car.printDistance();
        }
        ResultView.printNewLine();
    }
}
