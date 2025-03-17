import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRaceTest {

    @DisplayName("자동차 대수는 1대 이상이어야 합니다.")
    @Test
    public void receiveCarNumTest() {
        int numCar = CarRace.receiveCarNum();
        assertThat(numCar).isGreaterThan(0);
    }

    @DisplayName("시도 회수는 1 이상이어야 합니다.")
    @Test
    public void receiveNumTryTest() {
        int numTry = CarRace.receiveNumTry();
        assertThat(numTry).isGreaterThan(0);
    }
}
