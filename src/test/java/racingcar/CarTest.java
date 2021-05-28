package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    @Test
    @DisplayName("Car 생성자 테스트")
    public void createCarTest() {
        // given
        Car car = new Car("tomas");

        // then
        assertThat(car.getName()).isEqualTo("tomas");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름 검증하면서 Car 생성 테스트")
    public void createCarWithValidationTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("sophie",0));
    }
}
