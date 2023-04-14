package racingcar.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final String ENTER_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private final String ENTER_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String ENTER_TRY_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final String NO_MINUS_INPUT_PLEASE_RETRY = "음수는 입력할 수 없습니다.\n다시 입력해주세요.";

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int enterNumberOfCars() {
        int numberOfCars = -1;
        try {
            System.out.println(ENTER_NUMBER_OF_CARS);
            numberOfCars = scanner.nextInt();
            isValidateNum(numberOfCars);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            enterNumberOfCars();
        }
        return numberOfCars;
    }

    public String enterNameOfCars() {
        String nameOfCars = "";
        try {
            System.out.println(ENTER_NAME_OF_CARS);
            nameOfCars = scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            enterNameOfCars();
        }
        return nameOfCars;
    }

    public int enterNumberOfTry() {
        int numberOfTry = -1;
        try {
            System.out.println(ENTER_TRY_MESSAGE);
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
            throw new IllegalArgumentException(NO_MINUS_INPUT_PLEASE_RETRY);
        }
    }
}
