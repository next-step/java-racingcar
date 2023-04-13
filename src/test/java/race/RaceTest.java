package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RaceTest {
    @ParameterizedTest(name = "{0}개의 자동차로 {1}번 경주를 진행하면 {2}에 따라 결과는 {3}이다.")
    @MethodSource("getRaceTestStubs")
    void 주어진_횟수_동안_여러_대의_자동차는_전진_또는_멈출_수_있다(int numOfCars, int lap, PowerGenerator powerGenerator, boolean expected) {
        Cars cars = new Cars(numOfCars, powerGenerator);
        Race race = new Race(lap, cars);
        List<Boolean> result = race.start()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        assertThat(result.size()).isEqualTo(numOfCars * lap);
        assertThat(result.contains(!expected)).isFalse();
    }

    private static Stream<Arguments> getRaceTestStubs() {
        return Stream.of(
                Arguments.arguments(3, 3, new TestHelper.BigPowerGenerator(), true),
                Arguments.arguments(2, 4, new TestHelper.BigPowerGenerator(), true),
                Arguments.arguments(3, 2, new TestHelper.SmallPowerGenerator(), false),
                Arguments.arguments(1, 1, new TestHelper.SmallPowerGenerator(), false)
        );
    }
}
