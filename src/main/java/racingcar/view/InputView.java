package racingcar.view;

import java.util.*;

public class InputView {
    // 사용자에게 입력값을 받기위한 질문 및 Scanner 객체 선언
    private final Scanner scanner = new Scanner(System.in); // System.in 은 사용자로부터 입력을 받기 위한 입력 스트림이다.

    public int askCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int askTrialCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
