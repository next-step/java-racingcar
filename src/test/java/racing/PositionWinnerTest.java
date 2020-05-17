package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Car;
import racing.domain.PositionWinner;
import racing.domain.RaceWinner;
import racing.dto.RaceWinnerResult;
import racing.fake.FakeCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionWinnerTest {
    private static final int MAX_POSITION = 4;

    @ParameterizedTest
    @MethodSource("provideFakeCar")
    @DisplayName("우승자 계산 테스트")
    void calculatePositionTest(List<Car> cars) {
        RaceWinner raceWinner = new PositionWinner();
        RaceWinnerResult raceWinnerResult = raceWinner.calculateWinners(cars);
        List<String> winnerNames = cars.stream()
                .filter(car -> car.findCurrentPosition() == MAX_POSITION)
                .map(car -> car.getName())
                .collect(Collectors.toList());
        assertThat(raceWinnerResult.getWinnerNames()).isEqualTo(winnerNames);
    }

    private static Stream<Arguments> provideFakeCar() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                    createFakeCar("test1", MAX_POSITION - 1),
                    createFakeCar("test2", MAX_POSITION),
                    createFakeCar("test3", MAX_POSITION - 3))
            )
        );
    }

    private static Car createFakeCar(String name, int position) {
        return new FakeCar(name, position);
    }
}
