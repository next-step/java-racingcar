package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @DisplayName("문자열 포장 객체 CarName 생성 확인")
    @Test
    void constructCarName() {
        //given
        String carName = "oyeon";
        CarName oyeon = new CarName(carName);

        //when
        String name = oyeon.value();

        //then
        assertThat(name).isEqualTo(carName);
    }

    @DisplayName("문자열 포장 객체 CarName 생성 예외 처리(길이가 5를 초과 할 경우)")
    @Test
    void constructCarNameException() {
        assertThatThrownBy(() -> {
            new CarName("hoyeon");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
