package studytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split_두가지이상의_값이_있을때는_각각_분리() {
        String data = "1,2";
        assertThat(data.split(",")).containsExactly("1", "2");
    }

    @Test
    void split_한가지_값만_존재할때는_한개의_원소만_반환() {
        String data = "1";
        assertThat(data.split(",")).containsExactly("1");
    }

    @Test
    void substring() {
        String data = "(1,2)";
        assertThat(data.substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 길이를 벗어나는 위치의 문자를 가져오려고 시도하면 Exception이 발생한다")
    void charAt() {
        String data = "abc";

        assertThatCode(() -> data.charAt(data.length() - 1))
            .doesNotThrowAnyException();
        assertThatThrownBy(() -> data.charAt(data.length()))
            .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
