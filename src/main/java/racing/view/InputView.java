package racing.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String carName = scanner.nextLine();
        return carName;
    }

    public static int inputTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int times = scanner.nextInt();
        return times;
    }
}
