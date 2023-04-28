package racing.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.rule.MustGoRacingRule;
import racing.domain.rule.RacingRule;

class CarsTest {


    @ParameterizedTest
    @DisplayName("자동차경주 테스트")
    @MethodSource(value = "generateCarListAndExpected")
    void raceWithMustGoRuleTest(List<Car> carList, List<Car> expected) {
        Cars cars = new Cars(carList);
        RacingRule racingRule = new MustGoRacingRule();
        List<Car> roundResult = cars.race(racingRule).getRoundResult();
        for (int i = 0; i < roundResult.size(); i++) {
            assertThat(roundResult.get(i).getPosition()).isEqualTo(expected.get(i).getPosition());
        }
    }

    private static Stream<Arguments> generateCarListAndExpected() {
        return Stream.of(
                Arguments.of(
                    Arrays.asList(new Car("test"), new Car("test", 4)),
                    Arrays.asList(new Car("test", 1), new Car("test", 5))
                ),
                Arguments.of(
                    Arrays.asList(new Car("test"), new Car("test")),
                    Arrays.asList(new Car("test",1), new Car("test", 1))
                    )
        );
    }
}src/main/java/racing/domain/Cars.java