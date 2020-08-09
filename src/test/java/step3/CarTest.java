package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.MoveOneForwardStrategy;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("jylee");
    }

    @Test
    @DisplayName("현재 위치를 가져온다.")
    public void getPosition() {
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("이동한다.")
    public void move() {
        int currentPosition = car.getPosition();
        assertThat(car.move(new MoveOneForwardStrategy()).getPosition()).isEqualTo(currentPosition + 1);
    }

}
