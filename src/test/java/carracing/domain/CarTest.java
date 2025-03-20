package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("자동차 한 번 전진 동작 테스트 - 4 미만")
    @Test
    void car_move_below_4() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car)
                .extracting("distance")
                .isEqualTo(1);
    }

    @DisplayName("자동차 한 번 전진 동작 테스트 - 4 이상")
    @Test
    void car_move_over_4() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car)
                .extracting("distance")
                .isEqualTo(2);
    }

    @DisplayName("랜덤 값에 따른 전진 여부 결정")
    @Test
    void car_move_random() {
        Car car = new Car("pobi");
        NumberGenerator testNumberGenerator = new TestNumberGenerator(
                List.of(0, 2, 1, 8, 5, 4, 9, 6, 7, 3, 1, 5, 1, 1, 7, 3, 6, 9, 4, 4, 5, 1, 2, 2, 6)
        );
        car.move(testNumberGenerator.generateNumber());
        assertThat(car)
                .extracting("distance")
                .isEqualTo(1);
    }

    @DisplayName("자동차 이름 저장 기능")
    @Test
    void car_name() {
        Car car = new Car("pobi");
        assertThat(car).extracting("name").isEqualTo("pobi");
    }
}
