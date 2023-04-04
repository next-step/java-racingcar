package learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"를 , 로 split 하면 1과 2로 나뉘어진다.")
    void testStringWithOneCommaTwo() {
        //arrange
        String target = "1,2";

        //act
        String[] split = target.split(",");

        //assert
        assertThat(split).containsExactly("1", "2");
    }
}
