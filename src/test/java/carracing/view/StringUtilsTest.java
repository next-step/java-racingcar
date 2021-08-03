package carracing.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringUtilsTest {

    @ParameterizedTest(name = "문자열을 count 만큼 반복한 문자열을 반환한다.")
    @CsvSource(value = {"-,3", "*,5", "@,10"})
    public void repeatSuccessTest(String str, int count) {
        assertThat(StringUtils.repeat(str, count))
                .isEqualTo(String.join("", Collections.nCopies(count, str)));
    }

    @DisplayName("빈 문자열이나 count 가 0 보다 작은 경우 예외가 발생한다.")
    @Test
    public void repeatFailTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtils.repeat("", 3))
                .withMessageContaining("")
                .withMessageContaining("3");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtils.repeat(null, 3))
                .withMessageContaining("null")
                .withMessageContaining("3");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtils.repeat("test", -1))
                .withMessageContaining("test")
                .withMessageContaining("-1");
    }

}