package learningTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("요구사항 1")
    void String_Split_Test() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");

        result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void String_Substring_Test() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3")
    void String_OutOfIndex_Test(){
        assertThatThrownBy(()-> "abc".charAt(3))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("");
    }

}
