package step2;

import java.util.*;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String getNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameOfCars = scanner.nextLine();

        return nameOfCars;
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return tryCount;
    }
}
