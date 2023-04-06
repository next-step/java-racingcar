package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        Assertions.assertArrayEquals(List.of("1","2").toArray(), result);
    }

    @Test
    void splitSingle() {
        String[] result = "1".split(",");
        Assertions.assertArrayEquals(List.of("1").toArray(), result);
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        Assertions.assertEquals("1,2", result);
    }

    @Test
    @DisplayName("charAt을 활용한 특정 위치 가져오는 테스트")
    void charAt() {
        String s = "abc";
        Assertions.assertEquals('a', s.charAt(0));
        Assertions.assertEquals('b', s.charAt(1));
        Assertions.assertEquals('c', s.charAt(2));
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
            s.charAt(3);
        });
    }
}
