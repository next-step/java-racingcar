package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
    private RacingCar racingCar = new RacingCar("test");

    @Test
    @DisplayName("차 이름을 조회할 경우 이름을 정상적으로 반환한다.")
    public void getNameProperly() {
        String carName = racingCar.getName();
        assertThat(carName).isEqualTo("test");
    }

    @Test
    @DisplayName("차 위치와 주어진 위치가 동일한 지 비교한다.")
    public void carPositionAndGivenPositionAreSame() {
        RacingCar racingCar = new RacingCar("car", 2);

        assertThat(racingCar.hasSamePosition(2)).isTrue();
    }

    @Test
    @DisplayName("차 이름을 입력하여 RacingCar를 생성할 수 있다.")
    public void generateRacingCarWithCarName() {
        RacingCar racingCar1 = new RacingCar("test");
        assertThat(racingCar1.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("빈 차 이름으로 RacingCar를 생성하면 예외가 발생해야 한다.")
    public void shouldThrowException_WhenCarNameIsEmpty() {
        assertThatThrownBy(() -> new RacingCar(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 문자열일 수 없습니다.");
    }

    @Test
    @DisplayName("입력된 차 이름이 6자 이상일 경우 RacingCar 생성 시 예외가 발생해야 한다.")
    public void shouldThrowException_WhenCarNameIsLongerThanSixCharacters() {
        assertThatThrownBy(() -> new RacingCar("test123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }
    ;
}