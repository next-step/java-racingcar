package step4;

import java.util.List;

public class RacingOption {

    private static final NumberGenerator DEFAULT_NUMBER_GENERATOR = RandomNumberGenerator.of(9);
    private static final String NAME_DELIMITER = ",";
    private static final int MINIMUM_NUMBER_OF_ROUND = 1;

    private final List<String> names;
    private final int numberOfRounds;
    private final NumberGenerator numberGenerator;


    public RacingOption(List<String> names, int numberOfRounds, NumberGenerator numberGenerator) {
        this.names = names;
        this.numberOfRounds = numberOfRounds;
        this.numberGenerator = numberGenerator;
    }

    public static RacingOption from(UserInput userInput) {
        String carNames = userInput.getCarNames();
        int numberOfRounds = userInput.getNumberOfRounds();
        validCheck(carNames, numberOfRounds);
        return new RacingOption(List.of(carNames.split(NAME_DELIMITER)), numberOfRounds, DEFAULT_NUMBER_GENERATOR);
    }

    private static void validCheck(String names, int numberOfRounds) {
        if (InputValidator.isInvalidNames(names)) {
            ResultView.printError("자동차의 이름은 최대 5글자이며, 콤마(,)로 구분해 입력 되어야 합니다.");
            throw new IllegalArgumentException();
        }
        if (numberOfRounds < MINIMUM_NUMBER_OF_ROUND) {
            ResultView.printError("레이싱 게임을 위해서는 라운드 수가 1회 이상 필요합니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<String> getNames() {
        return names;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public NumberGenerator getNumberGenerator() {
        return numberGenerator;
    }
}
