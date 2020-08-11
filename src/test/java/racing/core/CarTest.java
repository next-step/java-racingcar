package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car = new Car();

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("이동 성공 테스트")
    void moveSuccess(int randomNumber) {
        // given
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return randomNumber;
            }
        };

        // when
        String route = car.move(random.nextInt(RacingGame.TOTAL_CASES));

        // then
        assertThat(route).isEqualTo("-");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("이동 실패 테스트")
    void moveFailed(int randomNumber) {
        // given
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return randomNumber;
            }
        };

        // when
        String route = car.move(random.nextInt(RacingGame.TOTAL_CASES));

        // then
        assertThat(route).isEqualTo("");
    }

    @ParameterizedTest
    @MethodSource("provideArrayOfNumbersAndResult")
    @DisplayName("전체 이동 경로 확인 테스트")
    void route(int[] randomNumbers, String result) {
        // then
        String route = "";
        for (int r : randomNumbers) {
            // given
            Random random = new Random() {
                @Override
                public int nextInt(int bound) {
                    return r;
                }
            };
            route = car.move(random.nextInt(RacingGame.TOTAL_CASES));
        }

        // then
        assertThat(route).isEqualTo(result);
    }

    private static Stream<Arguments> provideArrayOfNumbersAndResult() {
        return Stream.of(
                Arguments.of(new int[] {1, 4, 5, 8 }, "---"),
                Arguments.of(new int[] {1, 2, 3, 3, 1}, ""),
                Arguments.of(new int[] {8, 4, 5, 9, 9}, "-----"),
                Arguments.of(new int[] {0, 1, 2, 7}, "-")
        );
    }
}

