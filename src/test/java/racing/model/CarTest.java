package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.mock.MockRandom;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("3단계 - 자동차 경주 - Car 단위 테스트")
class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차 랜덤 행동 이동 기능")
    void moveRandom() throws NoSuchFieldException, IllegalAccessException {
        Field fieldRandom = Car.class
                .getDeclaredField("random");
        fieldRandom.setAccessible(true);
        fieldRandom.set(car, new MockRandom()); // 0~9를 순차적으로 추출하는 MockRandom

        for (int i = 0; i < 10; i++) {
            car.moveRandom();
        }

        assertThat(car.getMovingDistance())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("자동차 전진 기능")
    void go() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method methodGo = Car.class
                .getDeclaredMethod("go");
        methodGo.setAccessible(true);

        methodGo.invoke(car);
        methodGo.invoke(car);
        methodGo.invoke(car);

        assertThat(car.getMovingDistance())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 정지 기능")
    void stopCar() {
        // 아무것도 하지않으면 정지

        assertThat(car.getMovingDistance())
                .isEqualTo(0);
    }
}
