package racingcar.racing.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

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

            String[] split = line.split(delimiter);
            List<String> result = Arrays.stream(split)
                    .map(String::trim)
                    .distinct()
                    .collect(Collectors.toList());

            if (split.length == result.size())
                return result;

            System.out.println("각각의 이름은 중복이 허용되지 않습니다. 다시 입력해 주세요. input: " + result);
        }
    }
}
