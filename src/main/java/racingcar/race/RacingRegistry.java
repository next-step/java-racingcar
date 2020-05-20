package racingcar.race;

import racingcar.util.CommonUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingRegistry {
    private static final String SPLIT_REGEX = ",";

    private RacingRegistry() {

    }

    public static List<Car> getCarList(String nameString) {
        CommonUtil.checkNullEmpty(nameString);

        String[] splitCars = nameString.split(SPLIT_REGEX);

        return Arrays.stream(splitCars)
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
