package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertDoesNotThrow(() -> {
            Car car = new Car();
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("전진 조건이 4~9 사이 정수면 전진 하지 않아서 상태바가 하나 존재")
    void move_range_check_success(int random) {
        Car car = new Car();
        car.move(random);
        assertEquals(car.getProgressBar(), "-");
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 1, 2, 3, 10, 100})
    @DisplayName("전진 조건이 4~9 사이 정수가 아니면 전진 하지 않아서 상태바가 아무것도 없음")
    void move_range_check_fail(int random) {
        Car car = new Car();
        car.move(random);
        assertEquals(car.getProgressBar(), "");
    }

}