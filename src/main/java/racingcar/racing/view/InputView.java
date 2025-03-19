package racingcar.racing.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Integer MAX_NAME_LENGTH = 5;

    public static int getPositiveNumberInput(String prompt) {
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

    public static List<String> getStringListInput(String prompt, String delimiter) {
        System.out.println(prompt);

        while (true) {
            String line = scanner.nextLine();

            List<String> result = Arrays.asList(line.split(delimiter));
            if (result.stream().allMatch(name -> name.length() <= MAX_NAME_LENGTH))
                return result;

            System.out.println("각각의 이름은 " + MAX_NAME_LENGTH + " 이하의 길이만 허용됩니다. 다시 입력해 주세요. input: " + result);
        }
    }
}
