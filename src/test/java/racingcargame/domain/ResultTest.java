package racingcargame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcargame.TestUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideRacingCars")
    void ofTest(List<RacingCar> racingCars) {
        Result result = Result.of(racingCars);
        List<String> currentStates = TestUtil.getPrivateField(result, "currentStates");

        assertThat(currentStates.size()).isEqualTo(racingCars.size());
    }

    private static Stream<Arguments> provideRacingCars() {
        List<RacingCar> zeroRacingCars = new ArrayList<>();
        List<RacingCar> racingCars = new ArrayList<>();

        racingCars.add(new RacingCar());
        racingCars.add(new RacingCar());

        return Stream.of(
                Arguments.of(zeroRacingCars),
                Arguments.of(racingCars)
        );
    }

}
