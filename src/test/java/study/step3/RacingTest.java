package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Car;
import step3.domain.Racing;
import step3.util.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingTest {

    @Test
    @DisplayName("Validator checkInput 메소드 carCount 0 체크 : IllegalArgumentException")
    void carCountZeroTest() {
        assertThatThrownBy(() -> Validator.checkInput(0, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 1대 이상이어야 합니다.");
    }

    @Test
    @DisplayName("checkInput 메소드 gameCount 0 체크 : IllegalArgumentException")
    void gameCountZeroTest() {
        assertThatThrownBy(() -> Validator.checkInput(1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 횟수는 1번 이상이어야 합니다.");
    }

    @DisplayName("Car 객체의 move 메소드 테스트")
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "4, 1",
            "9, 1",
    })
    void moveTest(int number, int result) {
        Car car = new Car(4);
        car.move(number);

        assertEquals(result, car.getDistance());
    }

    @DisplayName("initCarsTest 메소드 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void initCarsTest(int count) {
        Car[] cars = Racing.initCars(count);
        assertEquals(count, cars.length);
    }

}
