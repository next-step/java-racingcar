package racing_car.step03;

import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    public static int carCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return sc.nextInt();
    }

    public static int tryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return sc.nextInt();
    }

}
