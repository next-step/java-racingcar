import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @DisplayName("String 클래스의 split 메소드 동작 테스트")
    @Test
    public void testStringSplit()
    {
        String testStr1 = "1,2";
        assertThat(testStr1.split(",")).contains("1", "2");

        String testStr2 = "1";
        assertThat(testStr2.split(",")).containsExactly("1");
    }

    @DisplayName("String 클래스의 substring 메소드 동작 테스트")
    @Test
    public void testStringSubstring()
    {
        String testStr1 = "(1,2)";
        assertThat(testStr1.substring(1, testStr1.length()-1)).isEqualTo("1,2");
    }

    @DisplayName("String 클래스의 charAt 메소드 동작 테스트")
    @Test
    public void testStringCharAt()
    {
        String testStr1 = "abc";
        assertThatThrownBy(() -> testStr1.charAt(testStr1.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("Index out of range: %d은(는) %s의 인덱스를 넘어갑니다.", testStr1.length(), testStr1));
    }
}
