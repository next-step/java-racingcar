package racing;

import java.util.Scanner;

public class InputView {

    public static int getNumberOfCar() {
        System.out.println("자동차 대수는 몇 대인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int getTimeToTry() {
        System.out.println("시도할 회수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
