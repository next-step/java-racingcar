package StringSplit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitTest {
    @Test
    void split_string_1_and_2() {
        //given
        String testString = "1,2";
        //when
        String[] splitResult = testString.split(",");
        //then
        assertThat(splitResult).contains("1");
        assertThat(splitResult).contains("2");
        assertThat(splitResult).containsExactly("1","2");

    }

    @Test
    void split_string_1_return_array_contain_1(){
        //given
        String testString = "1";
        //when
        String[] splitResult = testString.split(",");

        //then
        assertThat(splitResult).contains("1");
        assertThat(splitResult).containsExactly("1");
    }

    @Test
    void  substring_method_test(){
        //given
        String testString = "(1,2)";
        //when
        String subStringResult = testString.substring(1,4);
        //then
        assertThat(subStringResult).isEqualTo("1,2");
    }
}
