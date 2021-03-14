package step3.view;

import java.util.Scanner;

public class InputView {

    private static final int ZERO = 0;

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getCountOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int countOfCars = Integer.parseInt(scanner.nextLine());
        if (countOfCars <= ZERO) {
            throw new IllegalArgumentException("0 이하의 숫자로는 자동차를 생성할 수 없습니다.");
        }
        return countOfCars;
    }

    public int getCountOfTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int countOfTry = Integer.parseInt(scanner.nextLine());
        if (countOfTry <= ZERO) {
            throw new IllegalArgumentException("0 이하의 숫자로는 이동을 시도할 수 없습니다.");
        }
        return countOfTry;
    }
}
