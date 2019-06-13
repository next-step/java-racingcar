package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");

    }

    @Test
    void substring() {
        String str = "(1,2)";
        String result = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void chatAt() {

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                            String abc = "abc";
                            abc.charAt(4);
                        }
                );

        assertThatThrownBy(() -> {
            String abc = "abc";
            abc.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

    }

    @AfterEach
    void tearDown() {

    }
}
