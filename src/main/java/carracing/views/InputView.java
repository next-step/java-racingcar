package carracing.views;

import java.util.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public String getCarCount() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
