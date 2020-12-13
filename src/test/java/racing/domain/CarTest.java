package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @Test
    @DisplayName("자동차 생성")
    void testCreateCar() {
        // given
        String name = "monds";
        // when
        Car car = new Car(name);
        // then
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 시 예외")
    void testCreateCarWithCarNameOver5Length() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("mondss"))
                .withMessageMatching("car name cannot exceed 5 characters: \\S+");
    }

    @Test
    @DisplayName("자동차 전진")
    void testCarMove() {
        // given
        Car car = new Car("monds");
        // when
        car.move();
        // then
        assertThat(car.getMovedDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름이 null 또는 empty 일 경우 예외")
    void testCarNameWithNullOrEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(input));
    }
}
