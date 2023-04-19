package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Car;
import racing.domain.Cars;
import racing.rule.MustGoRacingRule;
import racing.rule.RacingRule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("자동차경주 테스트")
    @MethodSource(value = "generateCarListAndExpectedPosition")
    void raceWithMustGoRuleTest(List<Car> carList, int first, int second) {
        Cars cars = new Cars(carList);
        RacingRule racingRule = new MustGoRacingRule();
        cars.race(racingRule);
        List<Integer> carsPosition = cars.currentRoundResult();
        assertThat(carsPosition).containsExactly(first, second);
    }

    private static Stream<Arguments> generateCarListAndExpectedPosition() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Car("test"), new Car("test", 4)), 2, 5),
                Arguments.of(Arrays.asList(new Car("test"), new Car("test")), 2, 2)
        );
    }
    @Test
    @DisplayName("자동차들의 위치배열 반환테스트")
    void valueOfCarsPositionTest() {
        Cars cars = new Cars(Arrays.asList(new Car("test"), new Car("test", 4), new Car("test", 1), new Car("test", 0)));
        List<Integer> carsPosition = cars.currentRoundResult();
        assertThat(cars.getCarList()).hasSize(4);
        assertThat(carsPosition).containsExactly(1, 4, 1, 0);
    }
}
