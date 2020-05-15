package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.strategy.FixedMovementStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipateCarsTest {

    private static Stream<Arguments> provideParticipateCarsInformation() {
        return Stream.of(
                Arguments.of(1, Arrays.asList(1)),
                Arguments.of(2, Arrays.asList(1, 0)),
                Arguments.of(3, Arrays.asList(1, 0, 1))
        );
    }

    @DisplayName("게임에 참여하는 자동차들에게 이동을 지시하고 List 타입의 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideParticipateCarsInformation")
    void tryMove(int numberOfCar, List<Integer> moveResult) {
        ParticipateCars participateCars = new ParticipateCars(numberOfCar);
        List<Integer> actualResult = participateCars.moveCars(new FixedMovementStrategy());

        assertThat(actualResult).isEqualTo(moveResult);

    }
}
