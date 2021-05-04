package step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static step5.Util.getSplitInputs;

class UtilTest {

    @Test
    void 이름입력_테스트() {
        // given & when
        String[] names = getSplitInputs("moon ,ch ild , IU, ");
        String[] expect = {"moon", "child", "IU"};
        // then
        assertThat(names).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ", " , ,", ""})
    void 이름입력_빈칸예외테스트(String input) {
        // given & when
        Throwable thrown = catchThrowable(() -> {
            getSplitInputs(input);
        });
        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}