package step04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private static Stream<Arguments> provideCarNameSplitResult() {
        return Stream.of(
                Arguments.of("1,2,3,4,5", new String[]{"1", "2", "3", "4", "5"})
        );
    }

    @DisplayName("자동차들의 이름 split 테스트")
    @ParameterizedTest
    @MethodSource("provideCarNameSplitResult")
    public void test_splitCarName(String names, String[] expected) {
        Cars cars = Cars.of(names, 0, () -> true);
        String[] result = cars.cars
                .stream()
                .map(car -> car.name)
                .toArray(String[]::new);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCarMoveResult() {
        return Stream.of(
                Arguments.of(true, 0, new Integer[]{1, 1, 1}),
                Arguments.of(false, 0, new Integer[]{0, 0, 0}),
                Arguments.of(false, 2, new Integer[]{2, 2, 2}),
                Arguments.of(true, 2, new Integer[]{3, 3, 3})
        );
    }

    @DisplayName("자동차들의 움직임 테스트")
    @ParameterizedTest
    @MethodSource("provideCarMoveResult")
    public void test_move(boolean isMovable, int position, Integer[] expected) {
        Cars cars = Cars.of("1,2,3", position, () -> isMovable);
        cars.move();
        Integer[] result = cars.cars
                .stream()
                .map(car -> car.getPosition())
                .toArray(Integer[]::new);

        assertThat(result).isEqualTo(expected);
    }

}

/*
1. { 메소드명 }_{ 테스트하려는상태 }_{ 기대하는동작 }
2. { 메소드명 }_{ 기대하는동작 }_{ 테스트하려는상태 }
3. test{ 테스트하려는 기능 }
4. { 테스트하려는 기능 }
5. Should_{ 기대하는 동작 }_When_{ 테스트 대상 상태 }
6. When_{ 테스트 대상 상태  }_Expect_{ 기대하는 동작  }
7. Given_{ 사전조건 }_When_{ 테스트 대상 상태 }_Then_{ 기대하는 동작 }
 */