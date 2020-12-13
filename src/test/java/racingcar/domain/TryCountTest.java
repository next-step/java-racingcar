package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TryCountTest {

    private TryCount count;

    @BeforeEach
    void init() {
        count = new TryCount(3);
    }

    @Test
    void create() {
        assertThat(count).isEqualTo(new TryCount(3));
    }

    @Test
    void executeGame() {
        count.executeGame();
        count.executeGame();
        assertThat(count).isEqualTo(new TryCount(1));
    }

    @Test
    void hasTryCount() {
        count.executeGame();
        count.executeGame();
        count.executeGame();
        boolean hasTryCount = count.hasTryCount();
        assertThat(hasTryCount).isEqualTo(false);
    }

}
