package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameManager {
    public static void main(String[] args) {
        InputView.displayMessage("자동차 대수는 몇 대 인가요?");
        int numberOfCars = InputView.getUserInput();

        InputView.displayMessage("시도할 회수는 몇 회 인가요?");
        int numberOfRounds = InputView.getUserInput();

        RacingCarGame game = new RacingCarGame(new RacingCarGroups(createRacingCars(numberOfCars)), numberOfRounds);
        game.runGame();
    }

    public static List<RacingCar> createRacingCars(int numberOfCars) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            RacingCar racingCar = new RacingCar(new GoStraightBehavior());
            racingCars.add(racingCar);
        }
        return racingCars;
    }
}