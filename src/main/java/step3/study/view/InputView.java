package step3.study.view;

import java.util.Scanner;

public class InputView {
    public String inputDriverNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public String inputRound(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.next();
    }
}
