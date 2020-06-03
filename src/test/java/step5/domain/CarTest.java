package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 테스트")
class CarTest {
    private Car car = new Car("testCar");

    @DisplayName("이동 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 2, 1})
    void move(int moveCnt) {
        for (int i = 0; i < moveCnt; i++) {
            car.move();
        }
        assertThat(car.getPosition()).isEqualTo(moveCnt);
    }

    @DisplayName("이름 확인")
    @Test
    void getName() {
        assertThat(car.getName()).isEqualTo("testCar");
    }

    @DisplayName("위치 확인")
    @Test
    void getPosition() {
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
