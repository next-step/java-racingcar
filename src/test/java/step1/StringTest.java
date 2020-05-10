package step1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void request1_split() {

        String testSource = "1,2";

        String[] result = testSource.split(",");
        assertThat(result).containsExactly("1", "2");

    }

    @Test
    public void request2_splitAndRemoveBrace() {

        String testSource = "(1,2)";
        String result = testSource.substring(1, testSource.length() - 1);
        assertThat(result).isEqualTo("1,2");

    }

    @DisplayName("String.charAt() 에서 위치 값의 범위가 벗어난 경우..")
    @Test
    public void request3_IndexOutOfBoundsTestByCharAt() {

        String testSource = "abc";
        assertThatThrownBy(() -> {
            testSource.charAt(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("The index argument is negative or not less than the length of this string.");

        /*
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    testSource.charAt(-1);
                }).hasMessageMatching();
        */
    }

}
