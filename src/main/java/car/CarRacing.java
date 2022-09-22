package car;

import java.util.Scanner;

public class CarRacing {
    public  CarRacing() {

    }

    public void start() {
        int carNum = enterCarCount();
        int tryNum = enterTryCount();
    }

    private int enterCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private int enterTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
