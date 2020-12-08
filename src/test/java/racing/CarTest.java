package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;
import racing.domain.condition.FixedCondition;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private final String TEST_CAR_NAME = "T_CAR";

    @DisplayName("자동차는 전진 하거나 멈출 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"0, 0", "4, 1", "9, 1"})
    public void move(int condition, int expected){
        //given
        Car car = new Car(new FixedCondition(condition), TEST_CAR_NAME);

        //when
        car.move();

        //then
        assertEquals(car.position(), expected);
    }

    @DisplayName("0 ~ 9 사이의 random 값을 구한 후 random 값이 4이상일 경우 전진한다")
    @ParameterizedTest
    @CsvSource(value = {"0, 0", "4, 1", "9, 1"})
    public void movingCar(int condition, int expected) {
        //given
        Car car = new Car(new FixedCondition(condition), TEST_CAR_NAME);

        //when
        car.move();
        
        //then
        assertEquals(car.position(), expected);
    }
}
