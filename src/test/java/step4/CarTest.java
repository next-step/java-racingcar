package step4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void inputCarExceptionTest() {
        assertThatThrownBy(() -> {
            new Car("123456");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void inputCarTest() {
        Car car = new Car("1234");

        assertThat(car.getName()).isEqualTo("1234");
        System.out.println(car.getPosition());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void getRandomNumTest() {
        Car car = new Car("123");
        assertThat(car.getRandomNum()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:true", "3:false"}, delimiter = ':')
    void isSatisfiedConditionForMoveTest(int number, boolean result) {
        Car car = new Car("123");
        assertThat(car.isSatisfiedConditionForMove(number)).isEqualTo(result);
    }
}
