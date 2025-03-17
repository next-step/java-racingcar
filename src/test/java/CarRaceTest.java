import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @DisplayName("자동차 대수로 양수를 받아야합니다. 초기 상태는 무조건 한칸(-)씩 있어야합니다. ")
    @Test
    public void initCurrentStateTest() {

        int negativeNumCar = -1;
        assertThatThrownBy(() -> CarRace.initCurrentState(negativeNumCar))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 대수는 양수 여야합니다.");

        int positiveNumCar = 3;
        String[] expectedValues = {"-", "-", "-"};
        String[] cars = CarRace.initCurrentState(positiveNumCar);
        assertThat(cars).containsExactly(expectedValues);
    }
}
