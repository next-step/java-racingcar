package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameInfoTest {
    private Rule rule = new RandomNumberRule(0, 10, 5 );

    @Test
    public void set_car_names() {
        RacingGameInfo racingGameInfo = new RacingGameInfo(rule, 5, "a, b,c, d");
        assertThat(racingGameInfo.getCars()).hasSize(4);
        assertThat(racingGameInfo.getCars().get(0).getName()).isEqualTo("a");
        assertThat(racingGameInfo.getCars().get(1).getName()).isEqualTo("b");
        assertThat(racingGameInfo.getCars().get(2).getName()).isEqualTo("c");
        assertThat(racingGameInfo.getCars().get(3).getName()).isEqualTo("d");
    }
}
