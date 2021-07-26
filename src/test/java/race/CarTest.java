package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    private static final int DEFAULT_TRY_COUNT = 5;

    @DisplayName("라운드까지의 이동거리값 반환")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:0"}, delimiter = ':')
    void getDistance(int round, int expected) {
        Car car = Car.of(DEFAULT_TRY_COUNT);
        car.move();
        assertThat(car.getDistance(round)).isGreaterThanOrEqualTo(expected);
    }

    @DisplayName("시도할 회수만큼 자동차 이동(전진 또는 멈춤)되었는지 확인")
    @Test
    void move() {
        Car car = Car.of(DEFAULT_TRY_COUNT);
        car.move();
        assertThat(car.getMoveCondition().size()).isEqualTo(DEFAULT_TRY_COUNT);
    }

    @DisplayName("전진하는 조건 확인 후 moveCondition리스트에 boolean추가된 것 확인 ")
    @Test
    void check() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Car car = Car.of(DEFAULT_TRY_COUNT);
        Method method = car.getClass().getDeclaredMethod("check");
        method.setAccessible(true);

        for (int i = 0; i < DEFAULT_TRY_COUNT; i++) {
            method.invoke(car);
        }
        assertThat(car.getMoveCondition().size()).isEqualTo(DEFAULT_TRY_COUNT);
    }

}