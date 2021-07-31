package step4.view.input;

import java.util.Scanner;

public class InputView {

    public Input receiveInput() {
        Scanner scanner = new Scanner(System.in);
        String[] carNames = receiveNames(scanner);
        int tryLimit = receiveTryLimit(scanner);
        scanner.close();

        return new Input(carNames, tryLimit);
    }

    private String[] receiveNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine().split(",");
    }

    private int receiveTryLimit(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
