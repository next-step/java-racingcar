package racingcar.domain.car;

import org.assertj.core.util.Streams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.strategy.FixedMovementStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipateCarsTest {

    private String[] nameOfCars;
    private List<CarMoveResult> expectedResult;

    private static Stream<Arguments> provideParticipateCarsInformation() {
        return Stream.of(
                Arguments.of(new String[]{"pobi"}, Arrays.asList(1)),
                Arguments.of(new String[]{"pobi", "crong"}, Arrays.asList(1, 0)),
                Arguments.of(new String[]{"pobi", "crong", "horox"}, Arrays.asList(1, 0, 1))
        );
    }

    @BeforeEach
    void setUp() {
        expectedResult = new ArrayList<>();
        nameOfCars = new String[]{"pobi", "crong", "horox"};
        int[] expectedLocation = new int[]{1, 0, 1};

        for (int i = 0; i < nameOfCars.length; i++) {
            expectedResult.add(new CarMoveResult(nameOfCars[i], expectedLocation[i]));
        }
    }

    @DisplayName("게임에 참여하는 자동차들에게 이동을 지시하고 CarMoveResult의 List를 반환한다.")
    @Test
    void tryMove() {
        ParticipateCars participateCars = new ParticipateCars(nameOfCars);
        List<CarMoveResult> actualResult = participateCars.moveCars(new FixedMovementStrategy());

        assertThat(actualResult).usingFieldByFieldElementComparator()
                .containsAll(expectedResult);

    }
}
