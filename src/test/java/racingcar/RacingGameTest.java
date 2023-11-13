package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingGameTest {

//    @Test
//    public void validate_음수_입력값() {
//        InputView inputView = new InputView();
//        String[] nameList = new String[] {"abc"};
//        assertThatThrownBy(() -> inputView.validateInput(nameList, -1)
//                .isInstanceOf(RuntimeException.class);
//    }

    @Test
    public void random_범위() {
        int random = RacingGame.getRandomValue();
        assertThat(random)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }

    @Test
    public void 전진_여부() {
        RacingCar car = new RacingCar("abc");
        car.moveOrStop(1);
        assertThat(car.getLocation())
                .isEqualTo(1);

        car.moveOrStop(4);
        assertThat(car.getLocation())
                .isEqualTo(2);
    }

    @Test
    public void 자동차_이름_5자_이하() {
        Assertions.assertThatThrownBy(() -> new RacingCar("abcdefg"))
                        .isInstanceOf(RuntimeException.class);
    }

}
