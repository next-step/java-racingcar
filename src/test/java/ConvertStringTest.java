import org.junit.jupiter.api.Test;
import racing.utils.ConvertString;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertStringTest {
    @Test
    void splitStringTest() throws Exception {
        //given
        String carString = "aaa,bbbbbb,ccc";
        //when
        String[] result = ConvertString.splitString(carString);
        //then
        assertThat(result[0]).isEqualTo("aaa");
        assertThat(result[1]).isEqualTo("bbbbbb");
    }
}
