package LearningTest;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    public void split() { // requirement1
        String str1 = "1,2";
        String[] result = str1.split(",");
        assertThat(result).contains("1", "2");
        String str2 = "1";
        String[] result2 = str2.split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    public void subString() { // requirement2
        String str3 = "(1,2)";
        assertThat(str3.substring(1, str3.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Retrieves a specific character using charAt() and confirms it raises an error when the index is out of bounds")
    public void chatAt() { // requirement3
        String str4 = "abc";
        assertThat(str4.charAt(0)).isEqualTo('a');
        assertThat(str4.charAt(1)).isEqualTo('b');
        assertThat(str4.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str4.charAt(str4.length()));
    }

}
