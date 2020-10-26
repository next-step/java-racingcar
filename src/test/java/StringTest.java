import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName(", 가 포함된 문자열을 split() 로 문자열을 쪼갤 수 있다")
    public void requirement1(){
        String source = "1,2";
        String [] result = source.split(",");

        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("구분자(,) 가 없는 문자열을 split() 로 쪼개면 원본문자열을 반환한다")
    public void requirement1_1(){
        String source = "1";
        String [] result = source.split(",");
        assertThat(result).hasSize(1);
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("substring() 로 원하는 문자열구간을 추출할 수 있다")
    public void requirement2(){
        String source = "(1,2)";
        int openBraceIdx = source.indexOf('(');
        int closeBraceIdx = source.indexOf(')');
        String result = source.substring(openBraceIdx+1,closeBraceIdx);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 로 index 에 해당하는 문자를 접근 할 수 있다")
    public void requirement3(){
        String source = "abc";

        assertThat(source.charAt(0)).isEqualTo('a');
        assertThat(source.charAt(1)).isEqualTo('b');
        assertThat(source.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("chatAt() 호출시 index 가 입력문자열크기를 벗어나면 exception 이 발생한다")
    public void requirement3_1(){
        String source = "abc";
        // Given
        // When
        int indexOutOfBounds = 4;
        Throwable thrown = catchThrowable(() -> source.charAt(indexOutOfBounds));

        // Then
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
