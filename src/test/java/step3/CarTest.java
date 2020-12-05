package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void createCarTest() {
        assertThat(car.getDashboard()).isNotNull();
        assertThat(car.getDashboard().getMileage()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0", "2,0", "3,0", "4,1", "7,1", "9,1"})
    @DisplayName("자동차 전진 테스트")
    void acceleratorTest(int input, int expected) {
        car.accelerate(input);
        assertThat(car.getDashboard().getMileage()).isEqualTo(expected);
    }

    @RepeatedTest(value = 10)
    @DisplayName("랜덤 숫자 테스트")
    void randomNumberTest() {
        assertThat(RandomNumberProvider.provideRandomNumber()).isBetween(0, 9);
    }
}
