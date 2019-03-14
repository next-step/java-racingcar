package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RacingGameInfoTest {
    private Rule rule = new RandomNumberRule(0, 10, 5 );

    @Test
    public void set_car_count() {
        RacingGameInfo racingGameInfo = new RacingGameInfo(rule, 5, 5);
        assertThat(racingGameInfo.getCars().size()).isEqualTo(5);
    }

    @Test
    public void set_car_names() {
        RacingGameInfo racingGameInfo = new RacingGameInfo(rule, 5, "a, b,c, d");
        assertThat(racingGameInfo.getCars().size()).isEqualTo(4);
        assertThat(racingGameInfo.getCars().get(0)).isEqualTo("a");
        assertThat(racingGameInfo.getCars().get(1)).isEqualTo("b");
        assertThat(racingGameInfo.getCars().get(2)).isEqualTo("c");
        assertThat(racingGameInfo.getCars().get(3)).isEqualTo("d");
    }
}
