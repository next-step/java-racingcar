package car.racingtest;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.racing.model.Car;
import car.racing.model.CarName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private final int CAR_MOVING_LIMIT = 4;

    @Test
    @DisplayName("자동차 입력이 정상적인지 확인")
    void 자동차_이름_테스트_정상() {
        String carName = "pobi";
        assertThatCode(() -> new Car(new CarName("hihi"))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 입력이 정상적인지 확인")
    void 자동차_이름_테스트_오류() {
        String carName = "pobiii";
        assertThrows(RuntimeException.class, () -> new Car(new CarName("ffffffff")));
    }

    @Test
    @DisplayName("단일 자동차 전진 테스트")
    void 단일_자동차_전진_확인() {
        Car car = new Car(new CarName("hi"));
        int randomNum = car.move();
        Assumptions.assumingThat((randomNum >= CAR_MOVING_LIMIT),
            () -> {
                Assertions.assertEquals(1, car.getPosition());
            });
    }

    @Test
    @DisplayName("단일 자동차 멈춤 테스트")
    void 단일_자동차_멈춤_확인() {
        Car car = new Car(new CarName("hello"));
        int randomNum = car.move();
        Assumptions.assumingThat((randomNum < CAR_MOVING_LIMIT),
            () -> {
                Assertions.assertEquals(0, car.getPosition());
            });
    }

}
