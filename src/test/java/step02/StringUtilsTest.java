package step02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {


    @ParameterizedTest
    @NullAndEmptySource
    void isBlank(String data) {
        assertThat(StringUtils.isBlank(data)).isTrue();
    }
}
