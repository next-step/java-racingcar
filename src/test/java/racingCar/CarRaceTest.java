package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarRaceTest {
    @Test
    void 입력받은_대수만큼_할당() {
        CarRace carRace = new CarRace();

        carRace.readyCar(3);

        Assertions.assertThat(carRace.getCars().size()).isEqualTo(3);
    }
}
