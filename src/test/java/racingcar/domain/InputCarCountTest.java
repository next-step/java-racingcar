package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.input.InputCarCount;
import racingcar.domain.input.exception.InvalidNumberException;
import racingcar.domain.input.exception.OnlyPositiveException;

import static org.assertj.core.api.Assertions.*;

class InputCarCountTest {

    @Test
    @DisplayName("문자열이 공란인 경우 IllegalArgumentException.class 예외(메시지 '최소 하나 이상의 이름을 입력해야합니다.')를 반환한다.")
    void inputBlankTest() {
        assertThatThrownBy(() -> new InputCarCount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 하나 이상의 이름을 입력해야합니다.");
    }

    @Test
    @DisplayName("문자열이 null 인 경우 IllegalArgumentException.class 예외(메시지 '최소 하나 이상의 이름을 입력해야합니다.')를 반환한다.")
    void inputNullTest() {
        assertThatThrownBy(() -> new InputCarCount(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 하나 이상의 이름을 입력해야합니다.");
    }

    @Test
    @DisplayName("'tom' 입력시 'tom' 이름의 Car 객체를 포함한 List<Car>를 반환한다.")
    void StringToCar() {
        assertThat(new InputCarCount("tom").toCars()).containsExactly(new Car("tom"));
    }

    @Test
    @DisplayName("'tom,anna' 입력시 'tom', 'anna' 이름의 Car 객체를 포함한 List<Car>를 반환한다.")
    void StringToCars() {
        assertThat(new InputCarCount("tom,anna").toCars()).containsExactly(new Car("tom"), new Car("anna"));
    }
}