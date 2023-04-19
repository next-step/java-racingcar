package racingcar.view;

import java.util.*;

public class InputView {
    // 사용자에게 입력값을 받기위한 질문 및 Scanner 객체 선언
    private final Scanner scanner = new Scanner(System.in); // System.in 은 사용자로부터 입력을 받기 위한 입력 스트림이다.

    public int askTrialCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public String[] askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String [] carNames = scanner.nextLine().split(",");

        return carNames;
    }


}
