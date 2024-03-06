package racing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public static int inputtedCarCount() {

        System.out.println("자동차 대수는 몇 대 인가요?");

        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                int result = scanner.nextInt();
                scanner.nextLine();
                return result;
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요");
            }
        }
    }
}
