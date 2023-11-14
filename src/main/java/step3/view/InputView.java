package step3.view;

import java.util.Scanner;

public class InputView {

    private static final String HOW_MANY_GET_CARS = "자동차 대수는 몇 대 인가요?";

    private static final String HOW_MANY_TRY = "시도할 회수는 몇 회 인가요?";

    private int carNumbers;

    private int tryNumbers;

    public void prepareRace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(HOW_MANY_GET_CARS);
        carNumbers = scanner.nextInt();
        System.out.println(HOW_MANY_TRY);
        tryNumbers = scanner.nextInt();
    }

    public int getCarNumbers() {
        return this.carNumbers;
    }

    public int getTryNumbers() {
        return this.tryNumbers;
    }
}
