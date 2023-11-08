package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    static int numCar;
    static int numAttempt;
    public static void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        numCar = getNumberOfCar(scanner);

        System.out.println("시도할 회수는 몇 회 인가요?");
        numAttempt = getNumAttempt(scanner);

        System.out.println("자동차의 수: " + numCar);
        System.out.println("시도 횟수: " + numAttempt);

        System.out.println("실행결과");
    }

    private static int getNumberOfCar(Scanner scanner) {
        return scanner.nextInt();
    }

    private static int getNumAttempt(Scanner scanner) {
        return scanner.nextInt();
    }
}
