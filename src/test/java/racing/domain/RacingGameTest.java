package racing.domain;

import org.junit.jupiter.api.BeforeEach;

class RacingGameTest {
    RacingGame racing;

    @BeforeEach
    void set() {
        racing = new RacingGame("1,2,3", 7);
    }
}
