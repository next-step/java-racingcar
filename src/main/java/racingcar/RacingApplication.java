package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.NumberGenerator;
import common.RandomNumberGenerator;
import racingcar.ui.InputView;

public class RacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String[] carNames = inputView.getCarNames();
        List<Vehicle> participateCar = getParticipateCar(carNames);
        int round = inputView.getRound();

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Game game = new RacingGame(participateCar, numberGenerator);
        Game gameRunner = new GameRunner(game);

        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            gameRunner.start();
        }
    }

    private static List<Vehicle> getParticipateCar(String[] carNames) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (String name : carNames) {
            vehicles.add(new Car(name));
        }
        return vehicles;
    }
}
