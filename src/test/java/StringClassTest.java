import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringClassTest {

    @Test
    public void 구분자로_분리되어야_한다() {
        //given
        String test = "1,2";

        //when
        String[] result = test.split(",");

        //then
        assertThat(result).containsExactly("1","2");
    }

    @Test
    public void 구분자가_없으면_분리되지_않는다() {
        //given
        String test = "1";

        //when
        String[] result = test.split(",");

        //then
        assertThat(result).containsExactly("1");
    }
}
