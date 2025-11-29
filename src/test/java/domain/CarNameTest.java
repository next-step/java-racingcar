package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarNameTest {
    @Test
    public void 자동차_이름_생성() {
        assertThat(new CarName("abcd")).isEqualTo(new CarName("abcd"));
    }

    @Test
    public void 다섯글자_넘는_자동차_이름() {
        assertThatThrownBy(() -> new CarName("abcdef")).isInstanceOf(RuntimeException.class);
    }

}
