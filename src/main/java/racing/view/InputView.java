package racing.view;

import racing.domain.RacingCar;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
    public static final String ERROR_MESSAGE = "잘못 입력하셨습니다.";

    public static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.println(ERROR_MESSAGE);
            return 0;
        }
    }

    public static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.println(ERROR_MESSAGE);
            return 0;
        }
    }

    public static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        try {
            return new Scanner(System.in).nextLine();
        } catch (NoSuchElementException e) {
            System.out.println(ERROR_MESSAGE);
            return null;
        }
    }
}
