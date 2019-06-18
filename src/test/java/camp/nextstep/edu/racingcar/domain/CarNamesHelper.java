package camp.nextstep.edu.racingcar.domain;

import java.util.Arrays;
import java.util.List;

public interface CarNamesHelper {
    String CAR_NAME_FIRST_VALUE = "FIRST";
    String CAR_NAME_SECOND_VALUE = "SECOND";
    String CAR_NAME_THIRD_VALUE = "THIRD";

    CarName CAR_NAME_FIRST = CarName.from(CAR_NAME_FIRST_VALUE);
    CarName CAR_NAME_SECOND = CarName.from(CAR_NAME_SECOND_VALUE);
    CarName CAR_NAME_THIRD = CarName.from(CAR_NAME_THIRD_VALUE);

    default CarNames getValidCarNames() {
        final List<CarName> carNameList = Arrays.asList(CAR_NAME_FIRST, CAR_NAME_SECOND, CAR_NAME_THIRD);
        return CarNames.from(carNameList);
    }
}
