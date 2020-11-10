package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameManager {
    public static void main(String[] args) {
        InputView.displayMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = InputView.getStringInput();

        InputView.displayMessage("시도할 회수는 몇 회 인가요?");
        int numberOfRounds = InputView.getUserInput();

        RacingCarGame game = new RacingCarGame(new RacingCarGroups(createRacingCars(carNames)), numberOfRounds);
        game.runGame();
    }

    public static List<RacingCar> createRacingCars(String carNames) {
        String[] names = carNames.split(",");

        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            RacingCar racingCar = new RacingCar(names[i].replaceAll(" ", ""), new GoStraightBehavior());
            racingCars.add(racingCar);
        }
        return racingCars;
    }
}
