package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private static final String TEST_CAR_NAME = "test";


    @Test
    void 자동차_이동_테스트() {
        {
            Car car = new Car(TEST_CAR_NAME, bound -> 3);
            int before = car.getDistance();
            car.increaseDistance();
            assertThat(car.getDistance()).isEqualTo(before);
        }
        {
            Car car = new Car(TEST_CAR_NAME, bound -> 5);
            int before = car.getDistance();
            car.increaseDistance();
            assertThat(car.getDistance()).isEqualTo(++before);
        }
    }

    @Test
    void 이름은_5글자_초과할_수_없습니다() {
        String overFiveName = "가나다라마";

        assertThatThrownBy(() -> new Car(overFiveName, bound -> 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자를 초과 할 수 없습니다.");
    }

    @Test
    void 최대이동거리_테스트() {
        int maxDistance = 4;
        Car car = new Car(TEST_CAR_NAME, maxDistance);

        assertThat(car.hasMaxDistance(maxDistance)).isTrue();
    }

}
