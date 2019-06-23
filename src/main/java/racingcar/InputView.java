package racingcar;

import java.util.Scanner;

public class InputView {
    static int i = 0;
    static Scanner scanner = new Scanner(System.in);

    public static int inputNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int inputNumberOfGames() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
