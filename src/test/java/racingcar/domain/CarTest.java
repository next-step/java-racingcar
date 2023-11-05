package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car();
    }

    @Test
    @DisplayName("생성된 자동차는 모두 0이라는 출발 포지션을 가진다.")
    void createNewCar() {
        assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("게임에서 정의한 움직일 수 있는 조건에 따라 반환되는 숫자만큼 자동차를 이동시킨다.")
    void randomMove(int position) {
        car.move(() -> position);

        assertThat(car.getPosition()).isEqualTo(position);
    }
}
