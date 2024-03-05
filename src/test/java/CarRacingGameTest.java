import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
class CarRacingGameTest {

    @Test
    public void giveCarCountAndTrialCountThenPrintCarMovement() throws Exception{
//        CarRacingGame.carRacing(3,3);
     }

    @Test
    @DisplayName("자동차는 값이 4 이상일때 전진한다.")
    public void carMovesWhenRandomNumberIsGreaterThanOrEqualFour() throws Exception{
//        assertThat(CarRacingGame.move()).isTrue();
    }

    @Test
    @DisplayName("자동차는 값이 3 이하일 때 정지한다.")
    public void carStopsWhenRandomNumberIsLessThanFour() throws Exception{
//        assertThat(CarRacingGame.move()).isFalse();
     }

    @Test
    @DisplayName("랜덤 숫자에 따라 자동차의 위치가 업데이트된다.")
    public void givenRandomNumberThenUpdateCarPosition() throws Exception{
//        CarRacingGame.move(4);
//        assertThat(CarRacingGame.updatePosition()).isEqualTo(1);
    }
}
