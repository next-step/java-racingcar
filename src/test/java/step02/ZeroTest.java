package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ZeroTest {

    @Test
    @DisplayName("0을 입력하면 객체를 생성한다")
    void createZeroNumber() {
        //when, then
        Number zero = new Zero();
        assertThat(zero).isEqualTo(new Zero());
    }

}
