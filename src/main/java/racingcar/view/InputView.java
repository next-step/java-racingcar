package racingcar.view;

import racingcar.dto.RacingCarGameRequest;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String CAR_SEPARATOR = ",";

    public static RacingCarGameRequest getUserInput() {
        String[] carNameList = getParticipatingCarNameArray();
        int playCount = getPlayingCount();
        return new RacingCarGameRequest(playCount, carNameList);
    }

    public static void printWrongInputMessage() {
        System.out.println(MessageConstant.WRONG_INPUT);
    }

    private static String[] getParticipatingCarNameArray() {
        System.out.println(MessageConstant.INPUT_CAR_NAME);
        return SCANNER.nextLine().trim().split(CAR_SEPARATOR);
    }

    private static int getPlayingCount() {
        System.out.println(MessageConstant.INPUT_PLAY_COUNT);
        String countInString = SCANNER.nextLine();
        try {
            return Integer.parseInt(countInString);
        } catch (NumberFormatException ex) {
            printWrongInputMessage();
            return getPlayingCount();
        }
    }
}
