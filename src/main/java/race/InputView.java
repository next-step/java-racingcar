package race;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public InputView(String input) {
        this.scanner = new Scanner(input);
    }

    public int askCarCount() {
        System.out.println(Car.QUESTION);

        int input;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("1 ~ 10 사이의 정수만 사용할 수 있습니다.");
        }

        Car.validateCarCountRange(input);

        return input;
    }

    public int askRoundCount() {
        System.out.println("시도할 이동 횟수는 몇 회 입니까?");

        int input;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("1 이상의 숫자만 사용할 수 있습니다.");
        }

        int minimumTrial = 1;
        if (input < minimumTrial) {
            throw new IllegalArgumentException("이동 횟수는 1회 이상으로 설정해야 합니다.");
        }

        return input;
    }
}
