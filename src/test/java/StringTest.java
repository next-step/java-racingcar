import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void splitWithComma(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");

        assertThat(result).containsExactly("1", "2");
//        assertThat(result).containsExactly("2", "1");
    }

    @Test
    void splitWithoutComma(){
        String[] result = "1".split(",");
        assertThat(result).contains("1");
        assertThat(result).hasSize(1);
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
}
