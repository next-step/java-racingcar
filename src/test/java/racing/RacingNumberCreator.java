package racing;

import org.junit.jupiter.api.Test;
import racing.model.RandomNumberCreator;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingNumberCreator {

    @Test
    void getZeroToNine() {
        assertThat(RandomNumberCreator.getZeroToNine()).isBetween(0,9);
    }
}
