package racingcar.view;

import racingcar.domain.game.GameInfo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static GameInfo inputGameInfo() {
        String nameOfCars = inputNameOfCars();
        int numberOfPhase = inputNumberOfPhase();

        return new GameInfo(nameOfCars, numberOfPhase);
    }

    private static String inputNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.nextLine();
    }

    public static int inputNumberOfPhase() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
