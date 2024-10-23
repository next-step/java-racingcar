import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CharAtTest {
    @Test
    void charAt()
    {
        String source = "abc";

        assertThat(source.charAt(0)).isEqualTo('a');
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> source.charAt(3));
    }
}
