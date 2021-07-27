package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import step3.runType.RunStrategy;
import step3.validatior.GameSettingValidator;

public class GameSetting {

    public static final int CAR_NAMES_INDEX = 0;
    public static final int ROUND_COUNT_INDEX = 1;

    private static final String COMMA_DELIMITER = ",";

    private List<String> carNames;
    private int carCount;
    private int roundCount;
    private RunStrategy runStrategy;

    public GameSetting(List<String> userInputs, RunStrategy runStrategy) {
        List<String> inputCarNames = generateCarNameList(userInputs);

        this.carNames = inputCarNames;
        this.carCount = this.carNames.size();
        this.roundCount = getInt(userInputs.get(ROUND_COUNT_INDEX));
        this.runStrategy = runStrategy;
    }

    private List<String> generateCarNameList(List<String> userInputs) {
        String carNamesString = userInputs.get(CAR_NAMES_INDEX);
        List<String> inputCarNames = splitAndTrimString(carNamesString);

        GameSettingValidator validator = GameSettingValidator.getInstance();
        validator.validateCarNames(inputCarNames);
        return inputCarNames;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public RunStrategy getRunStrategy() {
        return runStrategy;
    }

    private int getInt(String string) {
        return Integer.parseInt(string);
    }

    private List<String> splitAndTrimString(String string) {

        String[] stringArray = string.split(COMMA_DELIMITER);
        List<String> trimmedAndSplitStringList = trimStringArray(stringArray);

        return trimmedAndSplitStringList;
    }

    private List<String> trimStringArray(String[] stringArray) {
        return Arrays.stream(stringArray)
                .map(String::trim)
                .collect(Collectors.toList());
    }

}
