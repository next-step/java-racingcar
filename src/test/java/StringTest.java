import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class StringTest {
    @Test
    void splitTest1() {
        String str = "1,2";
        String[] splitString = str.split(",");
        assertThat(splitString).contains("1");
        assertThat(splitString).contains("2");
    }

    @Test
    void splitTest2() {
        String str = "1";
        String[] splitString = str.split(",");
        assertThat(splitString).containsExactly("1");
    }
}
