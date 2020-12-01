package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @DisplayName("스플릿 결과가 2개일 경우 스플릿이 잘 되는지 확인")
    @Test
    void splitTwoTest() {
        final String input = "1,2";
        final String delimiter = ",";

        String[] splitResult = input.split(delimiter);

        assertThat(splitResult).contains("1", "2");
    }

    @DisplayName("스플릿 결과가 하나일 경우 스플릿이 잘 되는지 확인")
    @Test
    void splitOneTest() {
        final String input = "1";
        final String delimiter = ",";

        String[] splitResult = input.split(delimiter);

        assertThat(splitResult).containsExactly("1");
    }
}
