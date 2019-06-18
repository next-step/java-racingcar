package carRacing.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {


    @Test
    void sptingSplitByComma() {
        String[] strings = StringUtils.sptingSplitByComma("hello,world,nice,to");
        assertThat(strings[0]).isEqualTo("hello");
        assertThat(strings[1]).isEqualTo("world");
        assertThat(strings[2]).isEqualTo("nice");
        assertThat(strings[3]).isEqualTo("to");
    }
}