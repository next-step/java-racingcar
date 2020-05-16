package study.step3;

import java.util.List;
import java.util.Scanner;

public class RacingGameLauncher {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InputView inputView = new InputView(scanner);

        RacingGame racingGame = new RacingGame.RacingGameBuilder()
                .setCarNumbers(inputView.inputCarNumber())
                .setTime(inputView.inputTryTime())
                .build();

        List<Car> result = racingGame.gameStart();
        ResultView resultView = new ResultView(result);
        resultView.print();
    }

}
