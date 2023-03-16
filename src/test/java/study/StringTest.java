package study;

import org.assertj.core.api.NotThrownAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class StringTest {


    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면StringIndexOutOfBoundsException 이 발생한다.")
    @Test
    void split3() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
                    "abc".charAt(4);
        }).withMessageMatching("Index: \\d+, Size: \\d+");
    }
}


