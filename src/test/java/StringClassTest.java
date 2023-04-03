import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringClassTest {

    @Test
    @DisplayName("\"1,2\" 문자열은 `,`구분자로 분리되어야 한다")
    public void commaSplitTest1() {
        //given
        String test = "1,2";

        //when
        String[] result = test.split(",");

        //then
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("\"1\" 문자열은 `,`구분자로 분리되지 않는다")
    public void commaSplitTest2() {
        //given
        String test = "1";

        //when
        String[] result = test.split(",");

        //then
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring 메소드로 `()`는 제거되어야 한다")
    public void substringTest() {
        //given
        String test = "(1,2)";
        
        //when
        String result = test.substring(1, test.length()-1);

        //then
        assertThat(result).isEqualTo("1,2");
    }
    
    @Test
    @DisplayName("charAt 메서드로 문자열의 문자를 가져올 수 있다")
    public void charAtTest() {
        //given
        String test = "abc";

        //when
        char a = test.charAt(0);
        char b = test.charAt(1);
        char c = test.charAt(2);

        //then
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }
    
    @Test
    @DisplayName("charAt으로 벗어난 위치의 문자열을 가져오면 인덱스 예외가 난다")
    public void charAtIndexOutOfExceptionTest() {
        //given
        String test = "abc";
        int outOfRange = test.length();

        //when then
        assertThatThrownBy(() -> test.charAt(outOfRange))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
