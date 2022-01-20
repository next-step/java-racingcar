package racinggame;

import java.io.IOException;
import java.util.List;
import racinggame.domain.Input;
import racinggame.domain.RacingCar;
import racinggame.domain.RacingGame;
import racinggame.domain.Utils;

public class Application {

    public static void main(String[] args) throws IOException {

        while (true) {
            String[] carNames;
            int trial;

            try {
                carNames = Input.getCarNames();
                trial = Input.getTrial();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            List<RacingCar> racingCars = RacingCar.createRacingCarFromCarNames(carNames);

            RacingGame racingGame = new RacingGame(racingCars, trial);
            racingGame.start();

            System.out.println("게임이 종료되었습니다. 중지하려면 q를 눌러주세요. 아무키나 누르면 다시 시작합니다.");
            String command = Utils.getInput();

            if (command.equals("q")) {
                break;
            }
        }
    }
}
