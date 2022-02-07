package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    public void 이름이_5자_이하인_차량은_Exception발생안함() {
        //given
        String name = "jason";

        //when

        //then
        assertThatCode(() -> Car.from(name)).doesNotThrowAnyException();
    }

    @Test
    public void 이름이_5자를_초과한_차량은_Exception발생() {
        //given
        String name = "jason1";

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car.from(name);
        });
    }
}