package car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.domain.model.Car;
import car.domain.model.CarName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private final int CAR_MOVING_LIMIT = 4;

    @Test
    @DisplayName("자동차 이름 입력이 정상적인지 확인")
    void 자동차_이름_테스트_정상() {
        // given
        String expectedCarName = "pobi";

        // when
        CarName carName = new CarName(expectedCarName);

        // then
        assertThat(carName).extracting("myCarName").isEqualTo(expectedCarName);
    }

    @Test
    @DisplayName("자동차 이름 길이가 5보다 길 경우")
    void 자동차_이름_테스트_오류() {
        // given
        String expectedCarName = "pobiii";

        // when -> then
        assertThrows(IllegalArgumentException.class, () -> new CarName(expectedCarName));
    }

    @Disabled
    @Test
    @DisplayName("단일 자동차 전진 테스트")
    void 단일_자동차_전진_확인() {
        String carName = "a";

        Car car = new Car(carName);
        int randomNum = car.move();

        Assumptions.assumingThat((randomNum >= CAR_MOVING_LIMIT),
            () -> {
                Assertions.assertEquals(1, car.getPosition());
            });
    }

    @Disabled
    @Test
    @DisplayName("단일 자동차 멈춤 테스트")
    void 단일_자동차_멈춤_확인() {
        String carName = "abcde";

        Car car = new Car(carName);
        int randomNum = car.move();

        Assumptions.assumingThat((randomNum < CAR_MOVING_LIMIT),
            () -> {
                Assertions.assertEquals(0, car.getPosition());
            });
    }

}
