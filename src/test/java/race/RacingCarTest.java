package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private RacingCar racingCar = new RacingCar("test");

    @Test
    @DisplayName("차 이름을 조회할 경우 이름을 정상적으로 반환한다.")
    public void getNameProperly() {
        String carName = racingCar.getName();
        assertThat(carName).isEqualTo("test");
    }

    @Test
    @DisplayName("랜덤으로 뽑은 값이 기준 이상일 경우 차는 한 칸 전진한다.")
    public void givenIntOverFour_racingCarShouldBeMoveForward() {
        FakeRandom fakeRandom = new FakeRandom(4);
        NumberPicker numberPicker = new NumberPicker(fakeRandom);
        RacingCar racingCar = new RacingCar("supercar", numberPicker);
        racingCar.moveForward();

        assertThat(racingCar.getPosition()).isEqualTo(1);
    }
}