package racingcar.domain.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.input.CarInfo;
import racingcar.domain.input.exception.InvalidCarNameException;
import racingcar.dto.InputCar;

import static org.assertj.core.api.Assertions.*;

class CarInfoTest {

    @Test
    @DisplayName("문자열이 공란인 경우 InvalidCarNameException.class 예외(메시지 '최소 하나 이상의 이름을 입력해야합니다.')를 반환한다.")
    void inputBlankTest() {
        assertThatThrownBy(() -> new CarInfo(""))
                .isInstanceOf(InvalidCarNameException.class)
                .hasMessage("최소 하나 이상의 이름을 입력해야합니다.");
    }

    @Test
    @DisplayName("문자열이 null 인 경우 InvalidCarNameException.class 예외(메시지 '최소 하나 이상의 이름을 입력해야합니다.')를 반환한다.")
    void inputNullTest() {
        assertThatThrownBy(() -> new CarInfo(null))
                .isInstanceOf(InvalidCarNameException.class)
                .hasMessage("최소 하나 이상의 이름을 입력해야합니다.");
    }
}