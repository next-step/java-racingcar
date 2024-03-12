package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @Nested
    @DisplayName("Car")
    class CarTest {
        Car car = new Car();
        @Test
        @DisplayName("(1)자동차의 위치를 전달")
        public void position() {
            int actual = car.position();
            Assertions.assertThat(actual).isEqualTo(0);
        }

        @Test
        @DisplayName("(2)자동차의 위치를 업데이트")
        public void updatePosition() {
            car.updatePosition();
            Assertions.assertThat(car.position()).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("CarArray")
    class CarArrayTest {
        @Test
        @DisplayName("(1)자동차 배열에 입력받은 갯수만큼 자동차 생성")
        public void 자동차배열() {

        }

        @Test
        @DisplayName("(2)자동차 배열 내의 모든 자동차 위치를 업데이트")
        public void 자동차배열위치업데이트() {

        }

        @Test
        @DisplayName("(3)자동차 배열 내의 자동차 위치 전달")
        public void 자동차배열내자동차위치전달() {

        }
    }

    @Test
    @DisplayName("Racing")
    public void 경주() {

    }
}
