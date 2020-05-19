package racingcar.race;

import racingcar.util.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingRegistry {
    private static final String SPLIT_REGEX = ",";

    private RacingRegistry() {

    }

    public static List<Car> getCarList(String nameString) {
        CommonUtil.checkNullEmpty(nameString);

        List<Car> carListJoinRace = new ArrayList<>();
        String[] splitCars = nameString.split(SPLIT_REGEX);

        Arrays.stream(splitCars).forEach(carName ->
                carListJoinRace.add(new Car(carName.trim())));
        return carListJoinRace;
    }

}
