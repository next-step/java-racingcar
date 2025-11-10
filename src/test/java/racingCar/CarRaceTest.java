package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarRaceTest {
    @Test
    void 입력받은_대수만큼_할당() {
        assertThat(new CarRace(3).getCars().size()).isEqualTo(3);
    }
}
