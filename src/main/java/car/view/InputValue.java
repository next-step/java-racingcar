package car.view;

import java.util.Scanner;

public class InputValue {
    private static Scanner scanner;

    public static String[] getCarsName() {
        scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String inputString = scanner.nextLine();
        return inputString.split(",");
    }

    public static int getRacingCount() {
        scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
