package calculator2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringNumberTest {

    @Test
    public void 생성() throws Exception {
        StringNumber stringNumber = StringNumber.create("1");
        assertThat(stringNumber.getNumber()).isEqualTo(1);
    }

    @Test(expected = RuntimeException.class)
    public void 음수_확인() throws Exception {
        StringNumber.create("-1");
    }
}
