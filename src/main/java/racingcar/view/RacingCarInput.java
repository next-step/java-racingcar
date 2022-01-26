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
        System.out.println(RacingCarOutput.REQUIRE_RACING_CAR_NAME);
        try {
            input = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.out.println(RacingCarOutput.ERROR_MESSAGE + e.getMessage());
        }
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public static int getRaceCount() {
        String input = "";
        System.out.println(RacingCarOutput.SYSTEM_MESSAGE_TRY_COUNT);
        try {
            input = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.out.println(RacingCarOutput.ERROR_MESSAGE + e.getMessage());
        }
        return Integer.parseInt(input);
    }
}
