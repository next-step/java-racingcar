import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringMethodTest {

    @DisplayName("쉼표로 split 했을 때 1과 2로 잘 분리되는지 확인한다")
    @Test
    void splitWithCommaForTwoElementsTest() {
        // Given
        String input = "1,2";

        // When
        String[] actual = input.split(",");

        // Then
        assertThat(actual)
                .as("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다")
                .containsExactly("1", "2");
    }

    @DisplayName("쉼표로 split 했을 때 1만 포함하는 배열이 반환되는지 확인한다")
    @Test
    void splitWithCommaForOneElementTest() {
        // Given
        String input = "1";

        // When
        String[] actual = input.split(",");

        // Then
        assertThat(actual)
                .as("\"1\"을 ,로 split 했을 때 1만 포함하는 배열이 반환되는지 확인한다")
                .contains("1");
    }
    
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환한다.")
    @Test
    void substringTest() {
        // Given
        String input = "(1,2)";

        // When
        String actual = input.substring(1, input.length() - 1);

        // Then
        assertThat(actual)
                .as("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환한다.")
                .isEqualTo("1,2");
    }

    @DisplayName("주어진 문자열에서 특정 위치의 문자를 가져온다")
    @Test
    void testCharAtSpecificPosition() {
        // Given
        String input = "abc";

        // When
        char result = input.charAt(1);  // 'b'를 가져옴

        // Then
        assertThat(result).isEqualTo('b');
    }

    @DisplayName("문자열의 범위를 벗어난 위치에서 charAt()을 호출하면 StringIndexOutOfBoundsException이 발생한다")
    @Test
    void testCharAtOutOfBounds() {
        // Given
        String input = "abc";

        // Then
        assertThatThrownBy(() -> {
            // When
            input.charAt(3);  // 인덱스 범위를 벗어남
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}
