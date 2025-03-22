package utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    void 비어있는문자열검사(){
        String str = "";
        assertThat(StringUtils.isEmpty(str)).isTrue();
    }

    @Test
    void null검사(){
        String str = null;
        assertThat(StringUtils.isEmpty(str)).isTrue();
    }

}
