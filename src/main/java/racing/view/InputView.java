package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String HOW_MANY_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String HOW_MANY_TRY = "시도할 회수는 몇 회 인가요?";
    private static final Pattern COMMA_REGEX = Pattern.compile(",");
    private static final int MAX_LENGTH = 5;

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputNames() {
        System.out.println(HOW_MANY_CARS);
        String input = scanner.next();

        if (input == null || input.isEmpty()) {
            throw new RuntimeException("Never allows empty input");
        }

        Arrays.stream(COMMA_REGEX.split(input))
            .forEach(validLength());

        return Arrays.stream(COMMA_REGEX.split(input))
            .collect(Collectors.toList());
    }

    public static int inputRound() {
        System.out.println(HOW_MANY_TRY);
        int input = scanner.nextInt();
        if (input <= 0) {
            throw new RuntimeException("Never allows or less than 0");
        }
        return input;
    }

    private static Consumer<String> validLength() {
        return carName -> {
            if (MAX_LENGTH < carName.length()) {
                throw new RuntimeException("Car names cannot be more than 5 characters long.");
            }
        };
    }

}
