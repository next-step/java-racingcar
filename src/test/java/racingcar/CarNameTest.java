package racingcar;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;

public class CarNameTest {

    @Test
    void 자동차_이름은_5자를_초과할_수_없다() {
        String character7 = "longName";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(character7))
                .withMessage("자동차 이름은 최대 5자입니다.");
    }

    @Test
    void 자동차_이름은_null_일_수_없다() {
        assertThatNullPointerException()
                .isThrownBy(() -> new CarName(null))
                .withMessage("자동차 이름에 null이 올 수 없습니다.");
    }

    @Test
    void 자동차_이름은_공백일_수_없다() {
        String blankName = "   ";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(blankName))
                .withMessage("자동차 이름은 공백일 수 없습니다.");
    }
}
