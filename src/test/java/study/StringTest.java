package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("String split()기능을 테스트")
    void splitTest(){
        String splitExampleInput = "1,2";

        String[] result = splitExampleInput.split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).contains("1","2");

        // containsExactly - 순서까지 일치 확인
//        assertThat(result).containsExactly("2","1");

        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("String substring() 기능 테스트")
    void substringTest(){
        String subStringExampleInput = "(1,2)";

        String subString = subStringExampleInput.substring(1, 4);

        assertThat(subString).isEqualTo("1,2");
    }

}
