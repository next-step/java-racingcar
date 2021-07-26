package study;

import java.util.Scanner;

public class InputView {

    public static int enterNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int numberOfCar = scanner.nextInt();
        return numberOfCar;
    }

    public static int enterNumberOfAttempt() {
        System.out.println("시도할 대수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        int numberOfAttept = scanner.nextInt();
        return numberOfAttept;
    }
}
