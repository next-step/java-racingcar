package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
}
