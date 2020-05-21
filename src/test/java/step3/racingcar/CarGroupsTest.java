package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGroupsTest {

    @DisplayName("CarGroups 일급 컬렉션 정상 생성 테스트 (CarFactory를 이용)")
    @ParameterizedTest
    @MethodSource("mockCarNamesBuilder")
    public void getNewCarGroupUsingCarFactory(String[] carNames) {
        CarGroups racingCars = new CarGroups(CarFactory.makeCars(carNames));

        int carCounts = carNames.length;
        assertThat(racingCars.getCarGroups().size())
                .isEqualTo(carCounts);

        boolean isPositionsDefaultZero = racingCars.getCarGroups().stream()
                .allMatch(car -> car.getPosition() == 0);
        assertThat(isPositionsDefaultZero)
                .isEqualTo(true);

        List<String> testTargetCarNames = racingCars.getCarGroups().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        List<String> originCarNames = Arrays.asList(carNames);
        List<String> filteredList = testTargetCarNames.stream()
                .filter(target -> originCarNames.stream().allMatch(Predicate.isEqual(target)))
                .collect(Collectors.toList());
        assertThat(filteredList.size())
                .isEqualTo(0);
    }

    @DisplayName("CarGroups에 Move를 요청함")
    @ParameterizedTest
    @MethodSource("mockCarNamesBuilder")
    public void moveCarGroups(String[] carNames) {
        CarGroups carGroups = new CarGroups(CarFactory.makeCars(carNames));
        carGroups.move();
        boolean isCarGroupsMoved = carGroups.getCarGroups()
                .stream()
                .allMatch(car -> car.getPosition() >= 0);
        assertThat(isCarGroupsMoved).isEqualTo(true);
    }

    private static Stream<Arguments> mockCarNamesBuilder() {
        return Stream.of(
                Arguments.of(
                       new String[]{"a", "b", "c", "d", "e"},
                       new String[]{"java", "js", "python", "go"},
                       new String[]{"tdd", "cleanCode"}
                )
        );
    }
}
