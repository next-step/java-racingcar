package car.domain.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    private static final String REGEX_CAR_NAME = ",";
    private final List<CarName> carNames;

    public CarNames(final String userInputCarNames) {
        validateCarNames(userInputCarNames);
        this.carNames = Arrays.stream(userInputCarNames.split(REGEX_CAR_NAME))
            .map(CarName::new).collect(Collectors.toList());
    }

    // [Review 7] 단순한 str 값이라도 의미 있는 매개변수 이름을 지어주는 것이 가독성에 좋다
    private void validateCarNames(final String userInputCarNames) {
        if (userInputCarNames.isBlank()) {
            throw new RuntimeException("입력값이 없습니다.");
        }
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

}
