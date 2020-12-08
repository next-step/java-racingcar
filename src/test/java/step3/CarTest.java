package step3;

import step3.model.RandomMovingStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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
        assertThat(car.getDistance()).isNotNull();
        assertThat(car.getDistance().getMileage()).isEqualTo(0);
    }

    @RepeatedTest(value = 5)
    @DisplayName("자동차 전진 테스트")
    void acceleratorTest() {
        car.accelerate(new RandomMovingStrategy());
        assertThat(car.getDistance().getMileage()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("자동차 전진 실패 테스트")
    void acceleratorFailTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> car.accelerate(null))
                .withMessageMatching("moving 전략이 필요합니다");
    }

    @RepeatedTest(value = 10)
    @DisplayName("랜덤 숫자 테스트")
    void randomNumberTest() {
        assertThat(RandomNumberProvider.provideRandomNumber()).isBetween(0, 9);
    }
}
