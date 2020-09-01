package racing.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @ParameterizedTest
    @ValueSource(strings={"에디, 조경현, 진석"})
    public void 문자열_나누기_테스트(String inputs) {
        assertThat(StringUtil.split(inputs)).hasSize(3);
    }

}
