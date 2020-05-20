package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 클래스 테스트")
public class CarTest {

    @Nested
    @DisplayName("move 메소드 호출 시")
    class Describe_move {
        private final String carName = "테스터";

        @DisplayName("차의 위치를 증가 시킬 수 있다.")
        @Test
        void it_does_move() {
            // given
            Car car = new Car(carName);
            int before = car.getPosition();

            // when
            car.move(new FixedNumberStrategy());

            // then
            assertThat(car.getPosition()).isEqualTo(before + 1);
        }

        @DisplayName("차의 위치를 증가 시키지 않을 수 있다.")
        @Test
        void it_does_not_move() {
            // given
            Car car = new Car(carName);
            int before = car.getPosition();

            // when
            car.move(new LowNumberStrategy());

            // then
            assertThat(car.getPosition()).isEqualTo(before);
        }
    }

    private static class LowNumberStrategy implements Strategy {
        @Override
        public int getNumber() {
            return 3;
        }
    }
}
