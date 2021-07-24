package step3.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {

    public static final String CAR_COUNT_KEY = "carCount";
    public static final String ROUND_COUNT_KEY = "roundCount";

    private static InputView inputView = new InputView();
    private Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public Map<String, Integer> readUserInputForGameSetting() {

        int carCount = askHowManyCars();
        int roundCount = askHowManyRounds();

        stopAskingUserByClosingScanner();

        Map<String, Integer> userInputs = new HashMap<>();
        userInputs.put(CAR_COUNT_KEY, carCount);
        userInputs.put(ROUND_COUNT_KEY, roundCount);

        return userInputs;
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
