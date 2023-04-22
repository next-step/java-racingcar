package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;
import racingcar.strategyTest.GoMoveStrategy;
import racingcar.strategyTest.MoveStrategy;
import racingcar.strategyTest.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("RacingCar 객체 생성 후 position = 0인지 확인")
    public void createRacingCar_ReturnPositionValueZero() {
        RacingCar racingCar = new RacingCar("test");
        int result = racingCar.position();

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("전략패턴을 통한 RacingCar move 실행후 position 인지 확인")
    public void moveRacingCar_ReturnPositionValueOne() {
        RacingCar racingCar = new RacingCar("test");
        RacingCar racingCar2 = new RacingCar("test2");
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        MoveStrategy goMoveStrategy = new GoMoveStrategy();

        racingCar.tryToMove(randomMoveStrategy);
        racingCar2.tryToMove(goMoveStrategy);

        int result = racingCar.position();
        int result2 = racingCar2.position();

        MoveStrategy moveStrategy = () -> true;
        racingCar2.tryToMove(moveStrategy);

        int result3 = racingCar2.position();

        assertThat(result).isLessThanOrEqualTo(1);
        assertThat(result2).isEqualTo(1);
        assertThat(result3).isEqualTo(2);
    }

    @Test
    @DisplayName("RacingCar 객체 생성 후 name = test 인지 확인")
    public void createRacingCar_ReturnNameTest() {
        RacingCar racingCar = new RacingCar("test");
        String result = racingCar.name();

        assertThat(result).isEqualTo("test");
    }

    @Test
    @DisplayName("RacingCar 객체 생성 후 name > 5 IllegalArgumentException 발생")
    public void carNameOverTheFive_ThrowException() {
//        assertThatCode(() -> {
//            RacingCar racingCar = new RacingCar("test23");
//        }).isInstanceOf(IllegalArgumentException.class);

        assertThatIllegalArgumentException().isThrownBy(() -> new RacingCar("test23"));
    }
}