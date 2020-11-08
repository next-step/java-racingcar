package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarSetInRaceTest {

    private CarSetInRace setInRace;

    @BeforeEach
    void setUp() {
        this.setInRace = new CarSetInRace();
        this.setInRace.move();
        this.setInRace.move();
        this.setInRace.stop();
        this.setInRace.move();

    }

    @Test
    @DisplayName("자동차가 이동한 거리의 기록이 일치하는지 확인")
    void 자동차_이동_기록_확인() {
        assertThat(setInRace.getMoveSize()).isEqualTo(3);
    }
}
