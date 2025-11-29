package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarNameTest {
    @Test
    public void 자동차_이름_생성() {
        assertThat(new CarName("abcd")).isEqualTo(new CarName("abcd"));
    }
}
