package step3.ui;

import java.util.Scanner;
import step3.domain.GameSetting;

public class InputView {

    private static InputView inputView = new InputView();
    private Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public GameSetting readUserInputForGameSetting() {
        int carCount = askHowManyCars();
        int roundCount = askHowManyRounds();

        stopAskingUserByClosingScanner();

        return new GameSetting(carCount, roundCount);
    }


    private int askHowManyCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private int askHowManyRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private void stopAskingUserByClosingScanner() {
        scanner.close();
    }

    public static InputView getInstance() {
        return inputView;
    }
}
