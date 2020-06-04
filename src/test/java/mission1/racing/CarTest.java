package mission1.racing;

import mission1.racing.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    Car car = new Car(5);

    @DisplayName("우승자를 제대로 가져오는지 확인 - 파라미터와 동일한 경우 true 반환")
    @ParameterizedTest
    @CsvSource(value = {"1 : false", "3 : false", "5 : true", "6 : false", "0 : false"}, delimiter = ':')
    void testGetWinner(int maxPosition, boolean expected) {
        assertEquals(car.isWinner(maxPosition), expected);
    }

    @DisplayName("자동차의 이동이 제대로 이뤄지는지 확인 - 파라미터가 4 이상일때 carPosition 증가 ")
    @ParameterizedTest
    @CsvSource(value = {"0, 5", "1, 5", "3, 5", "4, 6", "5, 6", "6, 6"}, delimiter = ',')
    void testCarGo(int randomValue, int expectedPosition) {
        car.go(randomValue);
        assertEquals(car.getCarPositions(), expectedPosition);
    }
}
