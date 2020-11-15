package racingcar.ui;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputCarNames() {
        System.out.println("step4 자동차 경주");
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public int getRepeatCount() {
        System.out.println("반복할 회수를 입력하세요. (1 이상)");
        return scanner.nextInt();
    }
}
