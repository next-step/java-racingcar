package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("현재 위치를 가져온다.")
    public void getPosition() {
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @DisplayName("이동한다.")
    public void move(int forwardDistance) {
        int currentPosition = car.getPosition();
        assertThat(car.move(forwardDistance).getPosition()).isEqualTo(currentPosition + forwardDistance);
    }

}
