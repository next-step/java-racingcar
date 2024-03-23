import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckSplitTest {
    private Entry entry = new Entry();

    @Test
    @DisplayName("쉼표_기준으로_나눔")
    void 쉼표_기준으로_나눔() {
        String input = " red,blue, white";
        String[] arr = entry.splitEntry(input);

        assertThat("red").isEqualTo(arr[0]);
        assertThat("blue").isEqualTo(arr[1]);
        assertThat("white").isEqualTo(arr[2]);
    }
}
