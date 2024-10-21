package Step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubstringIntegerTest {
    @Test
    void substring()
    {
        String source = "(1,2)";
        String sub_source = source.substring(1, 4);

       assertThat(sub_source).isEqualTo("1,2");
    }
}
