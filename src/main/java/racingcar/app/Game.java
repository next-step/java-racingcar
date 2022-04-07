package racingcar.app;

import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.dto.RoundResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void start() {
        List<Car> cars = generateCars();
        List<Round> rounds = generateRounds(cars);

        List<RoundResult> roundResults = playRounds(rounds);

        OutputView.printGameResult(roundResults);
    }

    private List<Car> generateCars() {
        int carCounts = InputView.inputCarCounts();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCounts; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    private List<Round> generateRounds(List<Car> cars) {
        int roundCounts = InputView.inputRounds();
        List<Round> rounds = new ArrayList<>();

        for (int i = 0; i < roundCounts; i++) {
            rounds.add(new Round(cars));
        }

        return rounds;
    }

    private List<RoundResult> playRounds(List<Round> rounds) {
        List<RoundResult> roundResults = new ArrayList<>();

        for (Round round : rounds) {
            roundResults.add(round.play());
        }

        return roundResults;
    }
}
