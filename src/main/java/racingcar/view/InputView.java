package racingcar.view;

import racingcar.domain.RacingCarGameRule;
import racingcar.dto.RacingCarGameRequest;

import java.io.IOException;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String CAR_SEPARATOR = ",";

    public RacingCarGameRequest getUserInput(RacingCarGameRule racingCarGameRule) throws IOException {
        String[] carNameList = getParticipatingCarNameArray(racingCarGameRule);
        int playCount = getPlayingCount();
        return new RacingCarGameRequest(playCount, carNameList);
    }

    private String[] getParticipatingCarNameArray(RacingCarGameRule racingCarGameRule) {
        System.out.println(MessageConstant.INPUT_CAR_NAME);
        String[] carNameArray = SCANNER.nextLine().trim().split(CAR_SEPARATOR);
        try {
            racingCarGameRule.validateCarName(carNameArray);
            return carNameArray;
        } catch (IllegalArgumentException exception) {
            System.out.println(MessageConstant.WRONG_INPUT);
            return getParticipatingCarNameArray(racingCarGameRule);
        }
    }

    private int getPlayingCount() {
        System.out.println(MessageConstant.INPUT_PLAY_COUNT);
        String countInString = SCANNER.nextLine();
        try {
            return Integer.parseInt(countInString);
        } catch (NumberFormatException ex) {
            System.out.println(MessageConstant.WRONG_INPUT);
            return getPlayingCount();
        }
    }
}
