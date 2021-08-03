package carracing.view;

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

    @ParameterizedTest(name = "빈 문자열이나 null인 경우 예외가 발생한다.")
    @CsvSource(value = {",3", "'',3", "test,-1"})
    public void repeatFailTest(String str, int count) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtils.repeat(str, count))
                .withMessageContaining(String.valueOf(str))
                .withMessageContaining(String.valueOf(count));
    }

}