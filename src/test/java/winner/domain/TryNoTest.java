package winner.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-01 14:19
 */
public class TryNoTest {
    @Test
    void tryNo_객체_생성() {
        assertThat(new TryNo(3)).isEqualTo(new TryNo(3));
    }

    @Test
    void tryNo_is_end_test() {
        TryNo tryNo = new TryNo(1);
        tryNo = tryNo.decrease();
        assertThat(tryNo.isNotEnd()).isFalse();
    }

    @Test
    void 음수_입력() {
        assertThatThrownBy(() -> {
            TryNo tryNo = new TryNo(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
