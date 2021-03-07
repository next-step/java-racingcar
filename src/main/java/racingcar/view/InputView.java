package racingcar.view;

import racingcar.domain.RacingCarGameRule;
import racingcar.dto.RacingCarGameRequest;
import racingcar.utils.StringUtil;

import java.io.IOException;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String CAR_SEPARATOR = ",";

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public RacingCarGameRequest getUserInput() throws IOException {
        String[] carNameList = getParticipatingCarNameArray();
        int playCount = getPlayingCount();
        return new RacingCarGameRequest(playCount, carNameList);
    }

    private String[] getParticipatingCarNameArray() {
        System.out.println(MessageConstant.INPUT_CAR_NAME);
        String[] carNameArray = SCANNER.nextLine().trim().split(CAR_SEPARATOR);
        try {
            validateCarName(carNameArray);
            return carNameArray;
        } catch (IllegalArgumentException exception) {
            System.out.println(MessageConstant.WRONG_INPUT);
            return getParticipatingCarNameArray();
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

    private void validateCarName(String[] carNameArray) {
        for (String carName : carNameArray) {
            validateWhetherCarNameIsBlack(carName);
            validateWhetherCarNameLengthLimit(carName);
        }
    }

    private void validateWhetherCarNameIsBlack(String carName) {
        if (StringUtil.isBlank(carName)) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
    }

    private void validateWhetherCarNameLengthLimit(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 너무 깁니다.");
        }
    }
}
