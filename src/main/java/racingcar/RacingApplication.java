package racingcar;

import java.util.ArrayList;
import java.util.List;

import common.NumberGenerator;
import common.RandomNumberGenerator;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.RacingGame;
import racingcar.domain.Vehicle;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String[] carNames = inputView.getCarNames();
        List<Vehicle> participateCar = getParticipateCar(carNames);
        int round = inputView.getRound();

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Game game = new RacingGame(participateCar, numberGenerator);

        ResultView resultView = new ResultView(participateCar);
        for (int i = 0; i < round; i++) {
            game.start();
            resultView.printResult();
        }
        resultView.printWinners();
    }

    private static List<Vehicle> getParticipateCar(String[] carNames) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (String name : carNames) {
            vehicles.add(new Car(name));
        }
        return vehicles;
    }
}
