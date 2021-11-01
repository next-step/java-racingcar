package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void splitTest1() throws Exception {
        //given
        String inputString = "1,2";
        String regex = ",";

        //when
        String[] splitResults = inputString.split(regex);

        //then
        assertThat(splitResults).containsExactly("1", "2");
    }

    @Test
    void splitTest2() throws Exception {
        //given
        String inputString = "1";
        String regex = ",";

        //when
        String[] splitResults = inputString.split(regex);

        //then
        assertThat(splitResults).containsExactly("1");
    }

    @Test
    void subStringTest() throws Exception {
        //given
        String inputString = "(1,2)";
        int bodyStartIdx = 1;
        int bodyEndIdx = inputString.length() - 1;

        //when
        String subStringResult = inputString.substring(bodyStartIdx, bodyEndIdx);

        //then
        assertThat(subStringResult).isEqualTo("1,2");
    }
}
