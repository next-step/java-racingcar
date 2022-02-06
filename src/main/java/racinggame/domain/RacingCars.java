package racinggame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private static final String SEPARATOR = ",";
    private static final String BLANK = "\\s+";
    private static final String EMPTY_STRING = "";

    private final List<RacingCar> racingCars;

    public RacingCars(final String inputCarNames) {
        final String[] carNames = parse(inputCarNames);
        racingCars = Arrays.stream(carNames)
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public RacingCars(List<RacingCar> racingCars){
        this.racingCars = racingCars;
    }

    private String[] parse(final String inputCarNames) {
        final String[] splitName = splitNameByComma(removeBlank(inputCarNames));
        Validator.checkNameIsBlank(splitName);

        return splitName;
    }

    private String removeBlank(final String trial) {
        return trial.replaceAll(BLANK, EMPTY_STRING);
    }

    private String[] splitNameByComma(final String inputCarNames) {
        return inputCarNames.split(SEPARATOR);
    }

    public List<RacingCar> get() {
        return racingCars;
    }
}
