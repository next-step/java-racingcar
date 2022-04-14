package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.PositiveInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("0 또는 자연수 값을 가지는 PositiveInteger 클래스 테스트")
public class PositiveIntegerTest {

    @Test
    @DisplayName("0미만의 값을 생성하면 예외가 발생한다.")
    void negativeValueTest() {
        assertThatThrownBy(() -> new PositiveInteger(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("add 메서드를 이용해서 두 PositiveInteger 를 더할 수 있다.")
    void addTest() {
        PositiveInteger one = new PositiveInteger(1);
        PositiveInteger two = new PositiveInteger(2);

        assertThat(PositiveInteger.add(one, two)).isEqualTo(new PositiveInteger(3));
    }
}
