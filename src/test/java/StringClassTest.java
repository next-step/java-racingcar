import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringClassTest {

    @Test
    public void splitTest() {
        //given
        String str = "1,2";

        //when
        String[] strSplits = str.split(",");

        //then
        assertThat(strSplits).contains("1","2");
        assertThat(strSplits).containsExactly("1", "2");
    }

    @Test
    public void substringTest() {
        //given
        String str = "(1,2)";

        //when
        str.substring(1, 4);

        //then
        assertThat(str).contains("1,2");
    }


    @DisplayName(value = "특정 위치의 문자를 가져오기")
    @Test
    public void charAtTest() {
        //given
        String str = "abc";

        //when
        char c = str.charAt(0);

        //then
        assertThat(c).isEqualTo('a');
    }

    @DisplayName(value = "특정 위치의 문자를 가져올 때 index out of Bounds Exception")
    @Test
    public void charAtWithIndexOutOfBoundsException() {
        //given
        String str = "abc";

        //when
        Throwable thrown = catchThrowable(() -> { str.charAt(3); });

        //then
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}
