import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingMangerTest {

    @Test
    @DisplayName("통합 테스트")
    void integration() {
        final int tryNum = 5;
        final RacingManger racingManger = new RacingManger("pobi,crong,honux");
        for (int i = 0; i < tryNum; i++) {
            racingManger.play();
        }
        final Car[] resultCar = racingManger.getCars();

        assertThat(resultCar.length).isEqualTo(3);
        for (Car car : resultCar) {
            assertThat(car.getPosition()).isBetween(0, tryNum);
        }
    }

    @Test
    void makeCars() {
        final RacingManger racingManger = new RacingManger("pobi,crong,honux");
        final Car[] cars = racingManger.getCars();

        assertThat(cars.length).isEqualTo(3);
        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
        assertThat(cars[0].getName()).isEqualTo("pobi");
        assertThat(cars[1].getName()).isEqualTo("crong");
        assertThat(cars[2].getName()).isEqualTo("honux");
    }

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.")
    void makeCars_name_exceed_5_length() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    new RacingManger("pobipo,crong,honux");
                }).withMessageMatching("name length exceed");
    }
}
