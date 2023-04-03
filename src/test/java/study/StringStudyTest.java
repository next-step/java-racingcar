package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringStudyTest {

    @Test
    void splitTest() {
        String commaString = "1,2";

        String[] result = commaString.split(",");

        assertThat(result.length).isEqualTo(2);
        assertThat(result).containsExactly("1", "2");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
    }

}