package racingCar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarViewTest {
    @Test
    void 자동차_이름과_포지션() {
        assertThat(new RacingCarView(new RacingCarName("a"), new Position(3)).toString()).isEqualTo("a : ---");
        assertThat(new RacingCarView(new RacingCarName("b"), new Position(1)).toString()).isEqualTo("b : -");
        assertThat(new RacingCarView(new RacingCarName("c"), new Position(0)).toString()).isEqualTo("c : ");
    }
}
