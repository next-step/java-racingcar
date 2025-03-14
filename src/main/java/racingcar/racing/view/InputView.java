package racingcar.racing.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getUserInput(String prompt) {
        System.out.println(prompt);

        while (true) {
            try {
                int result = scanner.nextInt();

                if (result > 0)
                    return result;

                System.out.println("양의 정수만 허용됩니다. 다시 입력해 주세요. input: " + result);
            } catch (InputMismatchException e) {
                System.out.println("양의 정수만 허용됩니다. 다시 입력해 주세요. input: " + scanner.nextLine());
            }
        }
    }
}
