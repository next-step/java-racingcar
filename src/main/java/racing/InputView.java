package racing;

import java.util.Scanner;

public class InputView {
    private static int numCar;
    private static int numAttempt;
    public static void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        numCar = scanner.nextInt();;

        System.out.println("시도할 회수는 몇 회 인가요?");
        numAttempt = scanner.nextInt();;

        System.out.println("자동차의 수: " + numCar);
        System.out.println("시도 횟수: " + numAttempt);

        System.out.println("실행결과");
    }

    public static int getNumberOfCar() {
        return numCar;
    }

    public static int getNumAttempt() {
        return numAttempt;
    }

}
