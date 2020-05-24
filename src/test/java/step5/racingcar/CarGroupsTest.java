package step5.racingcar;

import javafx.scene.paint.Stop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step5.racingcar.domain.Car;
import step5.racingcar.domain.CarFactory;
import step5.racingcar.domain.CarGroups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class CarGroupsTest {

    @DisplayName("CarGroups 일급 컬렉션 정상 생성 테스트")
    @ParameterizedTest
    @MethodSource("mockCarNamesBuilder")
    public void getNewCarGroupUsing(String[] carNames) {
        CarGroups carGroups = new CarGroups(Arrays.stream(carNames)
                .map(name -> new Car(name, () -> true))
                .collect(Collectors.toList()));

        int carCounts = carNames.length;

        assertThat(carGroups.getCarNames().size())
                .isEqualTo(carCounts);

        boolean isPositionsDefaultZero = carGroups.getCarPositions().stream()
                .allMatch(position -> position == 0);

        assertThat(isPositionsDefaultZero)
                .isEqualTo(true);

        List<String> testTargetCarNames = carGroups.getCarNames();
        List<String> originCarNames = Arrays.asList(carNames);

        assertThat(testTargetCarNames).isEqualTo(originCarNames);
    }

    @DisplayName("CarGroups에 Move 요청 뒤 position 테스트")
    @ParameterizedTest
    @MethodSource("mockCarNamesBuilder")
    public void moveCarGroups(String[] carNames) {
        CarGroups carGroups = new CarGroups(Arrays.stream(carNames)
                .map(name -> new Car(name, () -> true))
                .collect(Collectors.toList()));
        carGroups.move();

        boolean isCarGroupsMoved = carGroups.getCarPositions()
                .stream()
                .allMatch(position -> position == 1);

        assertThat(isCarGroupsMoved).isEqualTo(true);
    }

    private static Stream<Arguments> mockCarNamesBuilder() {
        return Stream.of(
                Arguments.of((Object) new String[]{"a", "b", "c", "d", "e"}),
                Arguments.of((Object) new String[]{"java", "js", "python", "go"}),
                Arguments.of((Object) new String[]{"a"}),
                Arguments.of((Object) new String[]{"tdd", "cleanCode"})
        );
    }

    @DisplayName("경주에서 이긴 winnerCarsName을 얻어오는 테스트")
    @Test
    public void getWinnerCarsName() {
        Car car1 = new Car("loser", () -> false);
        Car car2 = new Car("winner", () -> true);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        CarGroups carGroups = new CarGroups(cars);

        carGroups.move();
        List<String> winnerCarNames = carGroups.getWinnerCarNames();

        assertThat(winnerCarNames.size()).isEqualTo(1);
        assertThat(winnerCarNames.get(0)).isEqualTo("winner");
    }
}
