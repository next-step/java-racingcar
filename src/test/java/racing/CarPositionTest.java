package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.CarPosition;

import static org.assertj.core.api.Assertions.*;

public class CarPositionTest {

    @DisplayName("위치를 전달하면 자동차 위치 객체가 생성한다.")
    @Test
    void createCarPositionTest() {
        int position = 1;
        CarPosition carPosition = new CarPosition(position);

        assertThat(carPosition.getPosition()).isEqualTo(position);
    }

    @DisplayName("movePosition() 메소드를 호출하면 위치가 1증가한다.")
    @Test
    void moveCarPositionTest() {
        int defaultPosition = 0;
        CarPosition carPosition = new CarPosition(defaultPosition);
        carPosition.movePosition();

        assertThat(carPosition.getPosition()).isEqualTo(defaultPosition + 1);
    }
}
