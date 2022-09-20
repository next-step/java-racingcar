package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void 요구사항1_split시_1과2분리_확인(){
        String givenString = "1,2";

        String[] split = givenString.split(",");

        assertThat(split).contains("1","2");
    }

    @Test
    void 요구사항1_split시_1만_포함하느배열_확인(){
        String givenString = "1";

        String[] split = givenString.split(",");

        assertThat(split).containsExactly("1");
    }
}
