package racingcar.view;

import racingcar.domain.InputValidator;

import java.util.Scanner;

public class RacingGameInputView {

    public static String getCarsName() {

        Scanner sc = new Scanner(System.in);
        String CarsName = null;
        boolean isProperInput = false;

        while (!isProperInput) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            CarsName = sc.nextLine();
            isProperInput = InputValidator.checkCarsNameInput(CarsName);
        }
        return CarsName;
    }

    public static int getRound() throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        String round = null;

        System.out.println("시도할 횟수는 몇 회인가요?");
        boolean isProperInput = false;
        while (!isProperInput) {
            round = sc.nextLine();
            isProperInput = InputValidator.checkRoundNumberInput(round);
        }
        return Integer.parseInt(round);

    }
}
