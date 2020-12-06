package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("자동차를 위한 테스트")
class CarTest {

    @DisplayName("정상적인 자동차 생성 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 100, Integer.MAX_VALUE})
    void createCarTest(int expected) {
        // When
        Car car = new Car(new CarPosition(expected));

        // Then
        assertAll(
                () -> assertThat(car).isNotNull(),
                () -> assertThat(car.getPosition().getNumber()).isEqualTo(expected)
        );
    }
}
