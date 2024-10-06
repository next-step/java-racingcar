package race;

import org.junit.jupiter.api.Test;
import race.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    public void 차_위치와_주어진_위치가_동일한_지_비교한다() {
        RacingCar racingCar = new RacingCar("car", 2);

        assertThat(racingCar.hasSamePosition(2)).isTrue();
    }

    @Test
    public void 빈_이름으로_경주차를_생성하면_예외가_발생해야_한다() {
        assertThatThrownBy(() -> new RacingCar(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 문자열일 수 없습니다.");
    }

    @Test
    public void 입력된_차_이름이_6자_이상일_경우_경주차_생성시_예외가_발생해야_한다() {
        assertThatThrownBy(() -> new RacingCar("test123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}