package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private RacingCar racingCar = new RacingCar("test");

    @Test
    @DisplayName("한 칸 이동할 경우 위치가 1 증가한다.")
    public void moveForward_positionShouldBeIncrease() {
        int prevPosition = racingCar.getPosition();
        racingCar.moveForward();

        assertThat(racingCar.getPosition()).isEqualTo(prevPosition + 1);
    }

    @Test
    @DisplayName("차의 위치를 조회할 경우 position 값을 반환한다.")
    public void getPositionProperly() {
        racingCar.moveForward();
        racingCar.moveForward();

        int position = racingCar.getPosition();

        assertThat(position).isEqualTo(2);
    }

    @Test
    @DisplayName("차 이름을 조회할 경우 이름을 정상적으로 반환한다.")
    public void getNameProperly() {
        String carName = racingCar.getName();
        assertThat(carName).isEqualTo("test");
    }
}