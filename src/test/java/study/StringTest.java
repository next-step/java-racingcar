package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void srs1Test() {
        String value1 = "1,2";
        assertThat(value1.split(",")).contains("1");
        assertThat(value1.split(",")).contains("2");
        assertThat(value1.split(",")).containsExactly("1", "2");

        String value2 = "1";
        assertThat(value2.split(",")).contains("1");
        assertThat(value2.split(",")).containsExactly("1");
    }

    String srs2() {
        return "(1,2)".substring(1, "(1,2)".length() - 1);
    }

    @Test
    void srs2Test() {
        assertThat(srs2()).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3: \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    @Test
    void srs3Test() {
        String value = "abc";
        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> {
            value.charAt(3);
        }).isExactlyInstanceOf(StringIndexOutOfBoundsException.class);
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            value.charAt(3);
        });
    }
}
