package carracing.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarNames {

    public static final String NON_NULL_CAR_NAMES = "carNames 리스트 입력값은 null 일 수 없습니다";
    public static final String NOT_EMPTY_CAR_NAMES = "carNames 리스트 입력값은 비어있을 수 없습니다";

    private final List<CarName> carNames;

    public CarNames(List<String> carNames) {
        validateCarNames(carNames);
        this.carNames = toCarNames(carNames);
    }

    public Stream<CarName> getCarNamesStream() {
        return carNames.stream();
    }

    private void validateCarNames(List<String> carNames) {
        requireNonNull(carNames);
        requireNotEmpty(carNames);
    }

    private List<CarName> toCarNames(List<String> carNames) {
        return carNames.stream()
                .map(CarName::new)
                .collect(Collectors.toList());
    }

    private void requireNonNull(List<String> carNames) {
        if (Objects.isNull(carNames)) {
            throw new IllegalArgumentException(NON_NULL_CAR_NAMES);
        }
    }

    private void requireNotEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(NOT_EMPTY_CAR_NAMES);
        }
    }
}
