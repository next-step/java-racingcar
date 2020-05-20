package racing.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int inputCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int car = scanner.nextInt();
        return car;
    }

    public int inputTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int times = scanner.nextInt();
        return times;
    }
}
