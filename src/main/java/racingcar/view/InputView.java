package racingcar.view;

import java.util.Scanner;

public class InputView {
    private final String carNames;
    private final int moveCount;

    public InputView(String carNames, int moveCount) {
        this.carNames = carNames;
        this.moveCount = moveCount;
    }

    public static InputView create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();

        return new InputView(carNames, moveCount);
    }

    public String getCarNames() {
        return carNames;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
