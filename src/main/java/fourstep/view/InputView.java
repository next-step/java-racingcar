package fourstep.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String str = scanner.next();
        String[] strArr = str.split(",");
        return strArr;
    }

    public static int inputRaceCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("정수값만 입력해 주세요.");
            scanner = new Scanner(System.in);
            return inputRaceCount();
        }
    }
}

