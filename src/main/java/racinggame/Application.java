package racinggame;

import java.io.IOException;
import java.util.List;
import racinggame.domain.Input;
import racinggame.domain.RacingCar;
import racinggame.domain.RacingGame;
import racinggame.domain.Utils;

public class Application {

    public static void main(String[] args) throws IOException {
        String[] carNames;
        int trial;

        while (true) {
            try {
                carNames = Input.getCarNames();
                trial = Input.getTrial();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            List<RacingCar> racingCars = RacingCar.racingCarOf(carNames);
            RacingGame racingGame = new RacingGame(racingCars, trial);
            racingGame.start();

            System.out.println("게임이 종료되었습니다. (종료 = q, 다시 시작 = 아무 키 입력)");
            String command = Utils.getInput();

            if (RacingGame.isQuit(command)) {
                break;
            }
        }
    }
}
