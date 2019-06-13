package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    void charAtException() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                   "abc".charAt(4);
                });


    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

}
