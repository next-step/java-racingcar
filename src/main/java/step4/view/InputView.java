package step4.view;

import static step4.content.Constants.INPUT_CAR_NAMES_MESSAGE;
import static step4.content.Constants.INPUT_TRY_COUNT_MESSAGE;

import java.util.Scanner;

public class InputView {

    Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String enterCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    public int enterTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
