package step3.study.view;

import java.util.Scanner;

public class InputView {
    public String inputCarCount(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.next();
    }

    public String inputTryCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇 대 인가요?");
        return scanner.next();
    }
}
