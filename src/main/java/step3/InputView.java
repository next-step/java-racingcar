package step3;

import java.util.Scanner;

public class InputView {
    public static void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        String numCar = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numAttempt = scanner.nextInt();

        System.out.println("자동차의 수: " + numCar);
        System.out.println("시도 횟수: " + numAttempt);
    }
}
