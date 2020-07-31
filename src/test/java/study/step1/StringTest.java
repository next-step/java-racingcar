package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항1-1")
    void splitTest1() {
        String[] resultArray = "1,2".split(",");
        assertThat(resultArray).contains("1");
        assertThat(resultArray).contains("2");
        assertThat(resultArray).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1-2")
    void splitTest2() {
        String[] resultArray = "1,".split(",");
        assertThat(resultArray).contains("1");
        assertThat(resultArray).containsExactly("1");
    }


    @Test
    @DisplayName("요구사항2")
    void substringTest2() {
        String inputData = "(1,2)".substring(1, 4);
        String[] resultArray = inputData.split(",");
        assertThat(resultArray).containsExactly("1", "2");
    }



    @Test
    @DisplayName("요구사항3")
    void charAtTest1() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 3");
    }
}
