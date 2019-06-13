package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @BeforeEach
    void setUp() {
        System.out.println("setup");

    }

    @Test
    public void split() {
        System.out.println("split test");

        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    public void subString() {
        System.out.println("subString test");

        String sub = "(1,2)";
        String com = sub.substring(1, 4);
        assertThat(com).isEqualTo("1,2");
    }

    @Test
    public void charAt() {
        System.out.println("charAt test");

        String charAt = "abc";
        assertThat(charAt.charAt(0)).isEqualTo('a');
        assertThat(charAt.charAt(1)).isEqualTo('b');
        assertThat(charAt.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    charAt.charAt(4);
                });
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
        System.out.println();
    }
}

// Record
// - 비포와 에프터는 테스트 케이스마다 실행된다.
// - 모든 테스트는 독립적으로 동작하도록 구현
// - 실행할떄의 순서도 무작위다.
