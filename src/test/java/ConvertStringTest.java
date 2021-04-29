import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.utils.ConvertString;

public class ConvertStringTest {
    @Test
    public void splitStringTest() throws Exception {
        //given
        ConvertString convertString = new ConvertString();
        String carString = "aaa,bbbbbb,ccc";
        //when
        String[] result = convertString.splitString(carString);
        //then
        Assertions.assertThat(result[0]).isEqualTo("aaa");
        Assertions.assertThat(result[1]).isEqualTo("bbbbbb");
    }
}
