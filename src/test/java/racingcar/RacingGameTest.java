package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("random 값은 0~9 사이의 값으로 제한")
    public void random_범위() {
        int random = RacingGame.getRandomValue();
        assertThat(random)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("moveOrStop의 인수가 4 이상이면 전진, 미만이면 멈춤(location 변경 없음)")
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
    @DisplayName("자동차 이름은 5자 이하로 설정되어야 함")
    public void 자동차_이름_5자_이하() {
        Assertions.assertThatThrownBy(() -> new RacingCar("abcdefg"))
                        .isInstanceOf(RuntimeException.class);
    }

}
