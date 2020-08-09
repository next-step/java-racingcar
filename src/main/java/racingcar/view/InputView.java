package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getCountOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return Integer.valueOf(scanner.nextLine());
    }

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int getRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.valueOf(scanner.nextLine());
    }
}
