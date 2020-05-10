import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringClassTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    public void splitTest() {
        //given
        String testParameter = "1,2";

        //when
        String[] splitStringList = testParameter.split(",");

        //then
        assertThat(splitStringList).contains("1");
        assertThat(splitStringList).contains("2");
        assertThat(splitStringList).containsExactly("1","2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    public void splitTest2() {
        //given
        String testParameter = "1";

        //when
        String[] splitStringList = testParameter.split(",");

        //then
        assertThat(splitStringList).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현")
    public void subStringTest() {
        //given
        String testParameter = "(1,2)";

        //when
        String result = testParameter.substring(1, testParameter.length()-1);

        //then
        assertThat(result).isEqualTo("1,2");
    }
}