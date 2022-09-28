package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:1", "2:1", "3:1", "4:2", "5:2", "6:2", "7:2", "8:2", "9:2"}, delimiter = ':')
    @DisplayName("movePoint 가 4 이상일 때만 Car 의 position 증가하는지 테스트")
    public void carMoveTest(int movePoint, int expectedPosition) {
        Car car = new Car("testName");
        car.run(movePoint);
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
