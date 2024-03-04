package string;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void step1_mission() {
        // Given
        String existComma = "1,2";
        String nonExistComma = "1";

        // When & Then
        assertThat(existComma.split(",")).contains("1","2");
        assertThat(nonExistComma.split(",")).containsExactly("1");
    }
}
