import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class splitStringClassTest {

    @Test
    void split1And2String() throws Exception {
        // given
        String testString = "1,2";

        // when
        String[] result = testString.split(",");

        // then
        assertThat(result).contains("1", "2");
    }

    @Test
    public void split1() throws Exception {
        // given
        String testString = "1";

        // when
        String[] result = testString.split(",");

        // then
        assertThat(result).containsExactly("1");
    }
}