package step5.View;

import java.util.Scanner;

public class InputView {

    Scanner scanner;

    public InputView () {
        this.scanner = new Scanner(System.in);
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        return carNames;
    }

    public int inputAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
        int attempt = scanner.nextInt();
        return attempt;
    }
}
