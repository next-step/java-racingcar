package step3.view.input;

import java.util.Scanner;

public class InputView {

    public InputDTO receiveInput() {
        Scanner scanner = new Scanner(System.in);
        int carCountInput = receiveCarCountInput(scanner);
        int tryCountInput = receiveTryCountInput(scanner);
        scanner.close();
        return new InputDTO(carCountInput, tryCountInput);
    }

    private int receiveCarCountInput(Scanner scanner) {
        printCarCountQuestion();
        return scanner.nextInt();
    }

    private int receiveTryCountInput(Scanner scanner) {
        printTryCountQuestion();
        return scanner.nextInt();
    }

    private void printCarCountQuestion() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    private void printTryCountQuestion() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }
}
