package racing.view;

import java.util.Arrays;
import java.util.Scanner;
import static racing.view.InputViewMessage.*;
import static racing.view.InputViewConfig.*;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int getVehicleCount() {
        int vehicleCount;
        do {
            System.out.print(FIRST_QUESTION);
        } while ((vehicleCount = inputNumberValidationCheck(scanner.next())) <= 0);
        return vehicleCount;
    }

    public static int getMaxCheckPoint() {
        int maxCheckPoint;
        do {
            System.out.print(SECOND_QUESTION);
        } while ((maxCheckPoint = inputNumberValidationCheck(scanner.next())) <= 0 );
        return maxCheckPoint;
    }

    public static String getInputNames() {
        String names = "";
        do {
            System.out.print(INPUT_CAR_NAME_QUESTION);
            names = scanner.next();
        } while (inputStringValidationCheck(names));
        return names;
    }

    private static int inputNumberValidationCheck(String input) {
        if(numberFormatCheck(input) == 0) {
            return 0;
        }
        return minimumValueCheck(input);
    }

    private static int minimumValueCheck(String input) {
        int value = Integer.parseInt(input);
        if(value <= 0)
            System.out.print(INPUT_VALIDATION_ERROR);

        return value;
    }

    private static int numberFormatCheck(String input) {
        if(!input.matches(NUMBER_REGEX)) {
            System.out.print(INPUT_FORMAT_VALIDATION_ERROR);
            return 0;
        }
        return minimumValueCheck(input);
    }

    private static boolean inputStringValidationCheck(String input) {
        if(stringNameMaxLength(input) > INPUT_STRING_LIMIT_SIZE) {
            System.out.print(INPUT_CAR_NAME_LENGTH_VALIDATION_ERROR);
            return true;
        }
        return false;
    }

    private static int stringNameMaxLength(String input) {
        String[] strings = input.split(INPUT_STRING_ARRAY_SEPARATOR);
        return Arrays.stream(strings)
                .mapToInt(String::length)
                .max()
                .getAsInt();
    }

}
