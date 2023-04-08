package step3;

import step3.view.InputView;

import java.util.Scanner;

public class RacingCarApplication {
    private final Scanner scanner = new Scanner(System.in);

    private void run() {
        final String carNumbers = InputView.inputCarNumbers(scanner);
        final String tryNumbers = InputView.inputTryNumbers(scanner);
    }

    public static void main(String[] args) {

    }
}
