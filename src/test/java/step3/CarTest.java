package step3;

import step3.model.RandomMovingStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("자동차 이름 부여 생성 테스트")
    void createCarWithNameTest() {
        Car car = new Car("BLACK");
        assertThat(car.getName().getName()).isEqualTo("BLACK");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"ABCDEF", "가나다라마바사"})
    @DisplayName("자동차 이름 부여 생성 실패 테스트")
    void createCarWithNameFailTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(input))
                .withMessageMatching("1자 이상 5자 이하의 이름이 필요합니다");
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
