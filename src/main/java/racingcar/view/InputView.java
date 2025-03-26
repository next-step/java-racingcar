package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String DEFAULT_DELIMITER = ",";

    private String[] carNames;
    private int attemptCount;

    public void initGameInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesInput = scanner.nextLine();
        this.carNames = parseInput(carNamesInput);

        System.out.println("시도할 횟수는 몇 회 입니까?");
        this.attemptCount = scanner.nextInt();
    }

    public String[] parseInput(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    public String[] getCarNames() {
        return this.carNames;
    }

    public int getAttemptCount() {
        return this.attemptCount;
    }
}
