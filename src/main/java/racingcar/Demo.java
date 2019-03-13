package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RacingGame racingGame = new RacingGame(inputView.getTimes());
        Referee referee = new Referee();

        inputView.input();

        List<Car> cars = new ArrayList<>();
        List<String> names = inputView.getNames();
        names.forEach(name -> cars.add(new Car(name)));

        outputView.printIntroduction();
        for (int i = 1; i <= racingGame.getTimes(); i++) {
            racingGame.race(cars, new RandomNumberGenerator());
            outputView.printBody(cars);
        }

        List<String> namesOfWinners = referee.pickNamesOfWinners(cars);
        outputView.printResult(namesOfWinners);
    }
}