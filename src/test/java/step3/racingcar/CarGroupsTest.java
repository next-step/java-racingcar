package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.racingcar.domain.CarFactory;
import step3.racingcar.domain.CarGroups;

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
        CarGroups carGroups = new CarGroups(CarFactory.makeCars(carNames));
        int carCounts = carNames.length;
        assertThat(carGroups.getCarNames().size())
                .isEqualTo(carCounts);

        boolean isPositionsDefaultZero = carGroups.getCarPositions().stream()
                .allMatch(position -> position == 0);
        assertThat(isPositionsDefaultZero)
                .isEqualTo(true);

        List<String> testTargetCarNames = carGroups.getCarNames();
        List<String> originCarNames = Arrays.asList(carNames);
        List<String> filteredList = testTargetCarNames.stream()
                .filter(target -> originCarNames.stream().noneMatch(Predicate.isEqual(target)))
                .collect(Collectors.toList());
        assertThat(filteredList.size())
                .isEqualTo(0);
    }

    @DisplayName("CarGroups에 Move 요청 뒤 position 테스트")
    @ParameterizedTest
    @MethodSource("mockCarNamesBuilder")
    public void moveCarGroups(String[] carNames) {
        CarGroups carGroups = new CarGroups(CarFactory.makeCars(carNames));
        carGroups.move();
        boolean isCarGroupsMoved = carGroups.getCarPositions()
                .stream()
                .allMatch(position -> position >= 0);
        assertThat(isCarGroupsMoved).isEqualTo(true);
    }
    
    @DisplayName("경주에서 이긴 winnerCarsName을 얻어오는 테스트")
    @ParameterizedTest
    @MethodSource("mockCarNamesBuilder")
    public void getWinnerCarsName(String[] carNames) {
        CarGroups carGroups = new CarGroups(CarFactory.makeCars(carNames));
        carGroups.move();
        List<String> getWinnerCarNames = carGroups.getWinnerCarNames();
        assertThat(getWinnerCarNames.size())
                .isGreaterThanOrEqualTo(1);
    }

    private static Stream<Arguments> mockCarNamesBuilder() {
        return Stream.of(
                Arguments.of((Object) new String[]{"a", "b", "c", "d", "e"}),
                Arguments.of((Object) new String[]{"java", "js", "python", "go"}),
                Arguments.of((Object) new String[]{"a"}),
                Arguments.of((Object) new String[]{"tdd", "cleanCode"})
        );
    }
}
