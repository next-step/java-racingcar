import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {
    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.\n" +
            "\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.\n")
    void requre1() {
        String str = "1,2";
        String[] split = str.split(",");
        assertThat(split).containsExactly("1", "2");
        str = "1";
        split = str.split(",");
        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.\n")
    void require2() {
        String str = "(1,2)";
        Assertions.assertEquals("1,2", str.substring(1, str.length()-1));
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.\n" +
            "String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.\n" +
            "JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.\n")
    void require3() {
        String str = "abc";
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> str.charAt(5));
        assertThatThrownBy(() -> {
            str.charAt(5);
        }).isExactlyInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
