package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getCountOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return Integer.valueOf(scanner.nextLine());
    }

    public static int getRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.valueOf(scanner.nextLine());
    }
}
