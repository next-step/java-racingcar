package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.util.Console;

public class RacingCarInput {

    private RacingCarInput() {

    }

    public static List<String> getCarName() {
        String input = "";
        RacingCarOutput.printRequestCarName();
        try {
            input = Console.readLine();
        } catch (IllegalArgumentException e) {
            RacingCarOutput.printExceptionMessage(e.getMessage());
        }
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public static int getRaceCount() {
        String input = "";
        RacingCarOutput.printRequestGameTry();
        try {
            input = Console.readLine();
        } catch (IllegalArgumentException e) {
            RacingCarOutput.printExceptionMessage(e.getMessage());
        }
        return Integer.parseInt(input);
    }
}
