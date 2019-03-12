package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        InputView.input();
        RacingGame racingGame = new RacingGame(InputView.getTimes());
        Referee referee = new Referee();

        List<Car> cars = new ArrayList<>();
        String[] names = InputView.getNames();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

        OutputView.printIntroduction();
        for (int i = 1; i <= racingGame.getTimes(); i++) {
            racingGame.race(cars, new RandomNumberGenerator());
            OutputView.printBody(cars);
        }
        List<Car> winners = referee.getWinners(cars);
        OutputView.printResult(winners);
    }
}
