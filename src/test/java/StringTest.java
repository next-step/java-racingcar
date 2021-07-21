import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    /*
        요구사항 1
        "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    */
    @DisplayName("요구 사항 1 :: split Test")
    @Test
    public void splitTest() {
        String str;

        str = "1,2";
        assertThat(str.split(","))
                .containsExactly("1", "2");

        str = "1";
        assertThat(str.split(","))
                .withFailMessage("1로 분리 실패 :: " + str)
                .containsExactly("1");
    }

    /*
        요구사항 2
        "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    */
    @ValueSource(strings = { "(1,2)", "1,2", "(1,2", "1,2)" })
    @DisplayName("요구 사항 2 :: substring Test")
    @ParameterizedTest
    public void substringTest(String str) {
        int startIndex = str.indexOf("(");
        int endIndex = str.indexOf( ")");
        if (endIndex > -1)
            str = str.substring(0, endIndex);
        if (startIndex > -1)
            str = str.substring(startIndex + 1);
        assertThat(str)
                .withFailMessage("문자열 분리 실패 :: " + str)
                .isEqualTo("1,2");
    }

    /*
        요구사항 3
        "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    */
    @ValueSource(ints = { 0, 1, 2 })
    @DisplayName("요구 사항 3 :: charAt Test")
    @ParameterizedTest
    public void charAtTest(int index) {
        String str = "abc";
        int length = str.length();

        if (index >= length) {
            assertThatThrownBy(() -> {
                throw new StringIndexOutOfBoundsException(index);
            }).isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining(
                            String.format("Index: %d, Size: %d", index, length));
        }
        System.out.println("charAt return : " + str.charAt(index));
    }
}

