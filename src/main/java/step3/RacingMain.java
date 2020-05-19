package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingMain {
    private static final String INPUT_TIMES = "시도할 회수는 몇 회 인가요";
    private static final String INPUT_CARS = "자동차 대수는 몇 대 인가요?";

    public static void main(String[] args) {
        RacingInput racingInput = new RacingInput();
        int carNumber = racingInput.InputInfo(INPUT_CARS);
        int gameCoin = racingInput.InputInfo(INPUT_TIMES);

        RacingGame racingGame = new RacingGame(carNumber);

        for(int i=0; i<gameCoin; i++) {
            racingGame.moveCars();
            RacingView.print(racingGame.getRacingCarList());
        }
    }
}

