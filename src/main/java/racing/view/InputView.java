package racing.view;

import java.util.Scanner;
import static racing.view.InputViewMessage.*;

public class InputView {

    private static final String numberRegex = "^[0-9]*$";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int getVehicleCount() {
        int vehicleCount;
        do {
            System.out.print(FIRST_QUESTION);
        } while ((vehicleCount = inputValidationCheck(scanner.next())) <= 0);
        return vehicleCount;
    }

    public static int getMaxCheckPoint() {
        int maxCheckPoint;
        do {
            System.out.print(SECOND_QUESTION);
        } while ((maxCheckPoint = inputValidationCheck(scanner.next())) <= 0 );
        return maxCheckPoint;
    }

    private static int inputValidationCheck(String input) {
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
        if(!input.matches(numberRegex)) {
            System.out.print(INPUT_FORMAT_VALIDATION_ERROR);
            return 0;
        }
        return minimumValueCheck(input);
    }

}
