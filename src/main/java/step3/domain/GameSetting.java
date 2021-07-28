package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import step3.runType.RunStrategy;

public class GameSetting {

    public static final int CAR_NAMES_INDEX = 0;
    public static final int ROUND_COUNT_INDEX = 1;

    private static final String COMMA_DELIMITER = ",";

    private List<CarName> carNames;
    private RoundCount roundCount;
    private RunStrategy runStrategy;

    public GameSetting(List<String> userInputs, RunStrategy runStrategy) {
        List<CarName> inputCarNames = generateCarNameList(userInputs);
        RoundCount roundCount = generateRoundCount(userInputs);

        this.carNames = inputCarNames;
        this.roundCount = roundCount;
        this.runStrategy = runStrategy;
    }

    private List<CarName> generateCarNameList(List<String> userInputs) {
        String carNamesString = userInputs.get(CAR_NAMES_INDEX);
        List<String> inputCarNames = splitAndTrimString(carNamesString);

        List<CarName> carNameList = inputCarNames.stream()
            .map(n -> new CarName(n))
            .collect(Collectors.toList());

        return carNameList;
    }

    private RoundCount generateRoundCount(List<String> userInputs) {
        int inputRoundCount = getInt(userInputs.get(ROUND_COUNT_INDEX));
        return new RoundCount(inputRoundCount);
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

    public int getCarCount() {
        return this.carNames.size();
    }

    public RunStrategy getRunStrategy() {
        return runStrategy;
    }

    private int getInt(String string) {
        return Integer.parseInt(string);
    }

    public List<CarName> getCarNames() {
        return carNames;
    }

    public RoundCount getRoundCount() {
        return roundCount;
    }
}
