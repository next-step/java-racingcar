package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TryCountTest {

    @Test
    void 생성() {
        TryCount tryCount = new TryCount(3);

        assertThat(tryCount).isEqualTo(new TryCount(3));
    }
}
