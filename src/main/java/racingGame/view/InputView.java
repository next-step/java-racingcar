package racingGame.view;

import racingGame.domain.InputValue;

import java.util.Scanner;

public class InputView {

    public  InputValue askInput(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNum = scanner.next();
        System.out.println("시도할 회수는 몇 회인가요?");
        String tryNum = scanner.next();

        return new InputValue(carNum, tryNum);
    }
}
