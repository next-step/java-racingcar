package carRacing;

import carRacing.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:1", "2:1", "3:1", "4:2", "5:2", "6:2", "7:2", "8:2", "9:2"}, delimiter = ':')
    @DisplayName("movePoint 가 4 이상일 때만 Car 의 position 증가하는지 테스트")
    public void carMoveTest1(int movePoint, int expectedPosition) {
        Car car = new Car("test");
        car.run(movePoint);
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("Car 이름 길이가 5자를 초과하면 예외가 발생하는지 테스트")
    public void carMoveTest2(){
        assertThatThrownBy(() -> {
            new Car("123456");
        }).isInstanceOf(RuntimeException.class);
    }
}
