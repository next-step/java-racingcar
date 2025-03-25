import domain.RacingGame;
import movingStrategy.RandomlyMove;
import ui.InputView;
import ui.ResultView;

import java.util.Scanner;

public class RacingGameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        String carInputPrompt = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        String trialCountPrompt = "시도할 회수는 몇 회 인가요?";
        String delimiter = ",";
        int bound = 10;
        int threshold = 4;

        String[] namesOfCar = inputView.queryStringArrayInputWithPrompt(carInputPrompt, delimiter);
        Integer numberOfTrial = inputView.queryIntegerInputWithPrompt(trialCountPrompt);
        RacingGame racingGame = RacingGame.of(namesOfCar, numberOfTrial, new RandomlyMove(bound, threshold));

        new ResultView(System.out).printResult(racingGame.start());
    }
}
