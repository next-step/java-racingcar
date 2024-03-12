package race.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputView {

    private static final String INVALID_INPUT_MESSAGE_FORMAT = "잘못된 입력값입니다. 다시 입력해주세요. %s";

    private static int numberOfCar;
    private static int countOfTrial;

    public static Map<String, Integer> requestInput() {
        Map<String, Integer> map = new HashMap<>();
        requestCars();
        requestCountOfTrial();
        map.put("numberOfCar", numberOfCar);
        map.put("countOfTrial", countOfTrial);
        return map;
    }

    private static void requestCountOfTrial() {
        try {
            System.out.println("시도할 회수는 몇 회 인가요?");
            countOfTrial = inputNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            requestCountOfTrial();
        }
    }

    private static void requestCars() {
        try {
            System.out.println("자동차 대수는 몇 대 인가요?");
            numberOfCar = inputNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            requestCars();
        }
    }

    private static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return toPositiveInt(value);
    }

    private static int toPositiveInt(String text) {
        try {
            int number = Integer.parseInt(text);
            if (number < 0) {
                throw new IllegalArgumentException(String.format(INVALID_INPUT_MESSAGE_FORMAT, text));
            }
            return number;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(INVALID_INPUT_MESSAGE_FORMAT, text));
        }
    }
}
