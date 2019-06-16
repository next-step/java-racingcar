package camp.nextstep.edu.racingcar.domain;

import java.util.Arrays;
import java.util.List;

public interface CarNamesHelper {
    String CAR_NAME_FIRST = "FIRST";
    String CAR_NAME_SECOND = "SECOND";
    String CAR_NAME_THIRD = "THIRD";

    default CarNames getValidCarNames() {
        final List<String> carNameList = Arrays.asList(CAR_NAME_FIRST, CAR_NAME_SECOND, CAR_NAME_THIRD);
        return CarNames.from(carNameList);
    }
}
