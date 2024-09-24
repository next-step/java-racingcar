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
}
