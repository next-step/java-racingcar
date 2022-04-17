package racing.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ForwardUtilTest {

    @Test
    void 네칸_이상일때_전진_가능() {
       Assertions.assertThat( ForwardUtil.isAvailableForward(5)).isTrue();
        Assertions.assertThat( ForwardUtil.isAvailableForward(3)).isFalse();
    }
}