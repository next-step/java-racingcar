import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Sample {

    @DisplayName("HELLO WORLD")
    @Test
    public void abc() {
        Assertions.assertThat(2).isEqualTo(2);
    }
}
