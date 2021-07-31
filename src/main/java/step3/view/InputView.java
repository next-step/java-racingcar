package step3.view;

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

        userInputs.add(askCarNames());
        userInputs.add(askHowManyRounds());

        stopAskingUserByClosingScanner();

        return userInputs;
    }


    private String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
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
