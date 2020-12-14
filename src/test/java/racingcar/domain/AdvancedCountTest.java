package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AdvancedCountTest {

    @Test
    void create() {
        assertThat(new AdvancedCount(1)).isEqualTo(new AdvancedCount(1));
    }

    @Test
    void add() {
        AdvancedCount count = new AdvancedCount(1);
        count.add();
        assertThat(count).isEqualTo(new AdvancedCount(2));
    }

}
