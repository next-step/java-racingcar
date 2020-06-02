package study.nextstep.stage5.view;

import java.util.Scanner;

public class StandardInputView implements InputView {
    Scanner scanner;
    public StandardInputView() {
        scanner = new Scanner(System.in);
    }

    public String[] getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine().split(",");
    }

    public int getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
