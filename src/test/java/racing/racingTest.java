package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class racingTest {

    private final String oneGoStraight = "-";
    private final String notStart = "";
    private Umpire umpire = new Umpire();


    @Test
    @DisplayName("Racer가 이동할 수 있을지 판단하고 이동할 수 있다면 위치값이 증가한다.")
    void goStraight_when_isGoStraight_true() {
        Racer racer = new Racer(0);
        umpire.resetAdvanceCondition();
        if (umpire.isGoStraight()) {
            racer.goStraight();
            String currentLocation = racer.getCurrentLocation();
            assertThat(currentLocation).isEqualTo(oneGoStraight);
        }
        if (!umpire.isGoStraight()) {
            String currentLocation = racer.getCurrentLocation();
            assertThat(currentLocation).isEqualTo(notStart);
        }

    }


}
