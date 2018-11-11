package calculator2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringNumberSetTest {

    private StringNumberSet stringNumberSet;

    @Test
    public void 합계() throws Exception {
        String[] texts = {"1", "2"};
        stringNumberSet = StringNumberSet.create(texts);
        assertThat(stringNumberSet.sum()).isEqualTo(3);
    }
}