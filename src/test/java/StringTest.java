import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void requirement1(){
        String source = "1,2";
        String [] result = source.split(",");

        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    public void requirement2(){
        String source = "(1,2)";
        String result = source.substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
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
