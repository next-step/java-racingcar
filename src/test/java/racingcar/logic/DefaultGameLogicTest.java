package racingcar.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultGameLogicTest {

    private static final Integer TEST_NUMBER_OF_CARS = 3;
    private List<Integer> carPositions;

    @BeforeEach
    void setUp() {
        carPositions = IntStream.range(0, TEST_NUMBER_OF_CARS)
                .mapToObj(i -> 0)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("랜덤숫자가 4이상인경우 전진하는것을 확인한다")
    void checkCarIsMovingForwardIfRandomNumberIsGratherThan4() {
        // given
        GameLogic gameLogic = new DefaultGameLogic(new MockRandomValueProvider(5));
        // when
        List<Integer> result = gameLogic.move(carPositions);
        // then
        for (Integer position : result) {
            assertThat(position).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("랜덤숫자가 4보다 작거나 같은경우 전진하지 않는것을 확인한다")
    void checkCarIsNotMovingForwardIfRandomNumberIsLessThanOrEqualTo4() {
        // given
        GameLogic gameLogic = new DefaultGameLogic(new MockRandomValueProvider(4));
        // when
        List<Integer> result = gameLogic.move(carPositions);
        // then
        for (Integer position : result) {
            assertThat(position).isEqualTo(0);
        }
    }
}
