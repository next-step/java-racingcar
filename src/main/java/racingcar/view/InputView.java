package racingcar.view;

import java.util.Scanner;

public class InputView {
    private String carNames;
    private int round;

    public void take() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        this.carNames = new Scanner(System.in).nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        this.round = new Scanner(System.in).nextInt();
    }

    public String carNames() {
        return this.carNames;
    }

    public int round() {
        return this.round;
    }
}
