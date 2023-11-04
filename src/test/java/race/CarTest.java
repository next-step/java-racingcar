package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("자동차가 이동 할 때, 4이상의 값이 나오면 이동한다.")
    @Test
    void goTest() {
        // given
        final Car car = new Car(() -> 9);

        // when
        car.move();

        // then
        assertThat(car.toString()).isEqualTo("-");
    }

    @DisplayName("자동차가 이동 할 때, 4미만의 값이 나오면 이동하지 않는다.")
    @Test
    void stopTest() {
        // given
        final Car car = new Car(() -> 2);

        // when
        car.move();

        // then
        assertThat(car.toString()).isEqualTo("");
    }

    @DisplayName("toString()은 자동차가 이동한 횟수 만큼 '-'를 출력한다.")
    @Test
    void toStringTest() {
        // given
        final Car car = new Car(() -> 8);

        // when
        car.move();
        car.move();
        car.move();

        // then
        assertThat(car.toString()).isEqualTo("---");
    }
}