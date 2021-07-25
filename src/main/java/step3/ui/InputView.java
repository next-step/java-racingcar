package step3.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {


    private static InputView inputView = new InputView();

    private Scanner scanner = new Scanner(System.in);
    private List<String> userInputs = new ArrayList<>();

    private InputView() {
    }

    public List<String> readUserInputs() {

        userInputs.add(askHowManyCars());
        userInputs.add(askHowManyRounds());

        stopAskingUserByClosingScanner();

        return userInputs;
    }


    private String askHowManyCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextLine();
    }

    private String askHowManyRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextLine();
    }

    private void stopAskingUserByClosingScanner() {
        scanner.close();
    }

    public static InputView getInstance() {
        return inputView;
    }
}
