package racing.domain;

import org.junit.jupiter.api.Test;
import racing.domain.exception.BlankNameException;
import racing.domain.exception.MaxNameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    void 이름_5자_초과시_예외발생() {
        assertThatThrownBy(() -> {
            new CarName("CarAAA");
        }).isInstanceOf(MaxNameLengthException.class);
    }

    @Test
    void 이름_공백시_예외발생() {
        assertThatThrownBy(() -> {
            new CarName("");
        }).isInstanceOf(BlankNameException.class);
    }

    @Test
    void 객체_equals() {
        assertThat(new CarName("CarA").equals(new CarName("CarA"))).isTrue();
    }

    @Test
    void toString_이름_문자열_오버라이딩() {
        assertThat(new CarName("CarA").toString()).isEqualTo("CarA");
    }
}
