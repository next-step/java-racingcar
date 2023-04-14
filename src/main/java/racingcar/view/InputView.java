package racingcar.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int enterNumberOfCars() {
        int numberOfCars = -1;
        try {
            System.out.println("자동차 대수는 몇 대 인가요?");
            numberOfCars = scanner.nextInt();
            isValidateNum(numberOfCars);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            enterNumberOfCars();
        }
        return numberOfCars;
    }

    public int enterNumberOfTry() {
        int numberOfTry = -1;
        try {
            System.out.println("시도할 회수는 몇 회 인가요?");
            numberOfTry = scanner.nextInt();
            isValidateNum(numberOfTry);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            enterNumberOfTry();
        }
        return numberOfTry;
    }

    private void isValidateNum(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.\n다시 입력해주세요.");
        }
    }
}
