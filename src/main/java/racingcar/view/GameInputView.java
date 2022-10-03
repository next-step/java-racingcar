package racingcar.view;

import java.util.Scanner;

import racingcar.domain.CarNames;
import racingcar.domain.Racing;

public class GameInputView {
    private final Scanner input;

    public GameInputView(Scanner input) {
        this.input = input;
    }

    public Racing racing() {
        return Racing.of(carNames(), tryCount());
    }

    private CarNames carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return CarNames.of(input.nextLine());
    }

    private int tryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return input.nextInt();
    }
}
