package racing.view;

import java.util.Scanner;

public class InputView {
    private final String carNames;
    private final int numberOfRound;

    private final static Scanner SCANNER = new Scanner(System.in);

    private InputView(String carNames, int numberOfRound) {
        this.carNames = carNames;
        this.numberOfRound = numberOfRound;
    }

    public static InputView enterInput() {
        return new InputView(enterCarName(), enterNumberOfRound());
    }

    private static String enterCarName() {
        System.out.println("경주할 자동차 이름을 입력 하세요(이름은 쉼표(,)를 기준 으로 구분)");
        return SCANNER.nextLine();
    }

    private static int enterNumberOfRound() {
        System.out.println("시도 횟수를 입력 하세요.");
        return SCANNER.nextInt();
    }

    public String getCarNames() {
        return carNames;
    }

    public int getNumberOfRound() {
        return numberOfRound;
    }
}
