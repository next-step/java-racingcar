package racinggame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private static final String SEPARATOR = ",";
    private static final String BLANK = "\\s+";
    private static final String EMPTY_STRING = "";

    private List<RacingCar> racingCars;

    public RacingCars(String inputCarNames) {
        String[] carNames = parse(inputCarNames);
        racingCars = Arrays.stream(carNames)
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private String[] parse(String inputCarNames) {
        String[] splitName = splitNameByComma(removeBlank(inputCarNames));
        Validator.checkNameIsBlank(splitName);

        return splitName;
    }

    private String removeBlank(String trial) {
        return trial.replaceAll(BLANK, EMPTY_STRING);
    }

    private String[] splitNameByComma(String inputCarNames) {
        return inputCarNames.split(SEPARATOR);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
