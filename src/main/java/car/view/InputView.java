package car.view;

import car.exceptions.NumberStringException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String enterCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int enterCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int inputCount = 0;
        try {
            inputCount = scanner.nextInt();
        } catch (InputMismatchException ignore) {
            throw new NumberStringException("숫자 형식이 아닙니다.");
        } finally {
            scanner.close();
        }
        return inputCount;
    }
}
