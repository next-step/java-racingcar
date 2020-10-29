package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 분리확인 및 1만을 포함하는 배열이 반환")
    public void split(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1").contains("2");
        assertThat(result).containsExactly("1","2");
    }
    @Test
    @DisplayName("substring() 메소드를 활용해 ()을 제거하고 1,2를 반환")
    public void subString(){
        String result = "(1,2)".substring(1,5);
        assertThat(result).contains("1,2");
    }
    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생확인")
    public void chatAt() {
        String result = "abc";
        assertThatThrownBy(() -> {
            result.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
