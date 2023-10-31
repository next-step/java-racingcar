import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitTest() {
        String splitString = "1,2";
        String[] splitResult = splitString.split(",");
        assertThat(splitResult).contains("1", "2");

        String noSplitString = "1";
        String[] noSplitResult = noSplitString.split(",");
        assertThat(noSplitResult).containsExactly("1");
    }

    @Test
    void substringTest() {
        String inputString = "(1,2)";
        String substringResult = inputString.substring(1,4);
        assertThat(substringResult).isEqualTo("1,2");
    }
}