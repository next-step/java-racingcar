package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.Referee;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ApplicationTest {

    @Test
    void 자동차_이름_테스트() {
        Referee referee = new Referee();
        assertThatThrownBy(() -> referee.checkCarNames("test_car_name,d,c")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이싱_카운트_테스트() {
        Referee referee = new Referee();
        assertThatThrownBy(() -> referee.checkCount("d")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> referee.checkCount("-1")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> referee.checkCount("0")).isInstanceOf(IllegalArgumentException.class);
    }
}