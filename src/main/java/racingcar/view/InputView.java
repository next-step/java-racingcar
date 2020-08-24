package racingcar.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int viewNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return checkEmpty(scanner.nextLine());
    }

    public int viewNumberOfTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return checkEmpty(scanner.nextLine());
    }

    private int checkEmpty(String input) {
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
