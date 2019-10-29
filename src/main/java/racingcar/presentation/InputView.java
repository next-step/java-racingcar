package racingcar.presentation;

import java.util.Scanner;

public class InputView {

    private String carNames;
    private int countOfMovesAttemps;

    public void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        carNames = scanner.nextLine();
    }

    public void inputCountOfMovesAttemps() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        countOfMovesAttemps = scanner.nextInt();
    }

    public String getCarNames() {
        return this.carNames;
    }

    public int getCountOfMovesAttemps() {
        return this.countOfMovesAttemps;
    }
}
