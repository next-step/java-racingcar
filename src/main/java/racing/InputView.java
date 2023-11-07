package racing;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static RaceInfo inputInfo() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int cars = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int trials = scanner.nextInt();

        return new RaceInfo(cars, trials);
    }
}
