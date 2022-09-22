package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("요구사항1: 문자열 split")
    public void split() {
        String target = "1,2";
        String[] splitResults = target.split(",");
        assertThat(splitResults).containsExactly("1", "2");

    }

    @Test
    @DisplayName("요구사항2: subString ")
    public void subString() {
        String target = "(1,2)";
        String subStringResults = target.substring(1, 4);

        assertThat(subStringResults).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3: 문자열 chatAt")
    public void charAt() {
        String target = "abc";
        int targetLength = target.length();
        assertThatThrownBy(() -> target.charAt(targetLength)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
