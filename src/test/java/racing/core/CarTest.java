package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car = new Car();

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("이동 성공 테스트")
    void moveSuccess(int cutLine) {
        // when
        car.move(new Random() {
            @Override
            public int nextInt(int bound) {
                return cutLine;
            }
        });
        String route = car.getRoute();

        // then
        assertThat(route).isEqualTo("-");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("이동 실패 테스트")
    void moveFailed(int cutLine) {
        // when
        car.move(new Random() {
            @Override
            public int nextInt(int bound) {
                return cutLine;
            }
        });
        String route = car.getRoute();

        // then
        assertThat(route).isEqualTo("");
    }

    @Test
    @DisplayName("전체 이동 경로 확인 테스트")
    void route() {
        // given
        int[] cutLines = {1, 4, 5};

        // when
        for (int c : cutLines) {
            car.move(new Random() {
                @Override
                public int nextInt(int bound) {
                    return c;
                }
            });
        }
        String route = car.getRoute();

        // then
        assertThat(route).isEqualTo("--");
    }
}

