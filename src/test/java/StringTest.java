import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split() 메서드 동작 Test")
    public void splitTest() {
        // given
        String testString = "1,2";

        // when
        String[] splitTestArr = testString.split(",");

        // then
        assertThat(splitTestArr).contains("1");
        assertThat(splitTestArr).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substringTest() 메서드 동작 Test")
    void substringTest() {
        // given
        String testString = "(1,2)";

        // when
        String substringTestString = testString.substring(1, testString.length() - 1);

        // then
        assertThat(substringTestString).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메서드 동작 Test_통과하는 {0,1,2} 와 실패하는 {3} 을 Exception 확인을 통해 함꼐 Test 진행")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void charAt(int index){
        // given
        String testString = "abc";
        char[] checkStringArr = {'a', 'b', 'c'};

        // when
        try{
            char alpha = testString.charAt(index);

        // then
            assertThat(alpha).isEqualTo(checkStringArr[index]);
        } catch (StringIndexOutOfBoundsException e){
            assertThat(e).hasMessage("String index out of range: 3");
        }
    }
}
