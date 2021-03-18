package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListStringUtilsTest {

    @DisplayName("")
    @Test
    void Null_검증() {
        // given
        List<String> strings = null;

        // when
        assertThat(ListStringUtils.isNull()).isTrue();
    }
}
