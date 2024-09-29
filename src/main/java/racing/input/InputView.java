package racing.input;

import racing.exception.InvalidNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public RaceInput racingInput() {
        System.out.println("자동차 대수는 몇대인가요?");
        int numOfCar = input();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numOfAttempt = input();

        return new RaceInput(numOfCar, numOfAttempt);
    }

    private int input() {
        while (true) {
            try {
                return getValue();
            } catch (InvalidNumberException ne) {
                System.out.println("입력 값은 0보다 커야 합니다.");
            } catch (InputMismatchException e) {
                System.out.println("입력 값은 0보다 큰 숫자여야 합니다. 입력값 = " + scanner.next());
            }
        }
    }

    private int getValue() {
        int result = scanner.nextInt();
        if (result < 1) {
            throw new InvalidNumberException();
        }
        return result;
    }
}
