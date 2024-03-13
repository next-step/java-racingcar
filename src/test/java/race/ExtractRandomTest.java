package race;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ExtractRandomTest {
    @Test
    void 랜덤_값_추출() {
        ExtractRandom extractRandom = new ExtractRandom();
        int value = extractRandom.getRandomNumber();
        assertThat(value).isBetween(0,9);
    }
}
