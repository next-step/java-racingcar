package carRacing.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getCarCount() {
        System.out.println("자동차의 대수는 몇 대 인가요?");
        int carCount = 0;
        try {
            carCount = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.err.println("정수를 입력하세요");

        }
        return carCount;
    }

    public int getRacingCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int racingCount = 0;
        try {
            racingCount = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.err.println("정수를 입력하세요");

        }
        return racingCount;
    }

}
