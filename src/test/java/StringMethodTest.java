import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
