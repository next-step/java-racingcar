package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    private static final int DEFAULT_POSITION = 1;
    private static final int DEFAULT_POSITION_FOR_TEST = 3;
    private static final String DEFAULT_CAR_NAME = "abc";

    @Test
    @DisplayName("자동차 위치의 초기값이 1로 설정되는지 테스트")
    void defaultCarPositionTest() {
        Car car = new Car();
        assertEquals(DEFAULT_POSITION, car.getPosition());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12345", "a2bc"})
    @DisplayName("자동차의 이름 세팅 테스트")
    void initializeCarNameTest(String input) {
        Car car = new Car(input);
        assertTrue(car.isSameName(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"5:4", "2:3", "4:4"}, delimiter = ':')
    @DisplayName("이동 조건에 부합 하는 경우만 전진하는지 테스트")
    void moveByConditionTest(int input, int expected) {
        Car car = new Car(DEFAULT_CAR_NAME, DEFAULT_POSITION_FOR_TEST);

        assertThat(car.moveByCondition(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Car 객체의 copy 여부 확인 테스트")
    void deepCopyTest() {
        Car car = new Car("a", 4);

        Car copiedCar = car.copy();

        assertEquals(car, copiedCar);
        assertEquals(car.getPosition(), copiedCar.getPosition());
    }
}