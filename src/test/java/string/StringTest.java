package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("String 클래스 학습테스트 요구사항 1")
    void stringSplitTest() {
        String value1 = "1,2";

        String[] split1 = value1.split(",");

        assertThat(split1).contains("1", "2");
        assertThat(split1).containsExactly("1", "2");

        String value2 = "1,";

        String[] split2 = value2.split(",");

        assertThat(split2).contains("1");
        assertThat(split2).containsExactly("1");
    }

    @Test
    @DisplayName("String 클래스 학습테스트 요구사항 2")
    void stringSubStringTest() {
        String value = "(1,2)";

        String substring = value.substring(1, 4);

        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 클래스 학습테스트 요구사항 3 - 정상적인 인덱스")
    void stringCharAtTest() {
        String value = "abc";

        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
    }


    @Test
    @DisplayName("String 클래스 학습테스트 요구사항 3 - 비정상적인 인덱스")
    void stringCharAtTest_invalidIndex() {
        String value = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> value.charAt(4))
                .withMessage("String index out of range: 4");
    }
}
