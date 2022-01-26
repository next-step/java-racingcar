package racinggame;

import java.util.List;
import racinggame.view.InputView;
import racinggame.domain.RacingCar;
import racinggame.domain.RacingGame;
import racinggame.domain.Utils;

public class Application {

    public static void main(String[] args) {

        while (true) {
            String[] carNames = InputView.getCarNames();
            int trial = InputView.getTrial();

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
