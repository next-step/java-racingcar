package nextstep;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PairTest {

    @Test
    public void pair_returns_first_and_second() {
        Pair<String, String> pair = new Pair<>("first", "second");

        assertThat(pair.getFirst()).isEqualTo("first");
        assertThat(pair.getSecond()).isEqualTo("second");
    }
}
