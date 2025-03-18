package carrace;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarRaceTest {

    @DisplayName("자동차 대수는 1대 이상이어야 합니다.")
    @Test
    public void receiveCarNumTest() {
        int negativeNumCar = -1;
        int positiveNumCar = 2;

        assertThatThrownBy(() -> CarRace.receiveCarNum(negativeNumCar))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 대수는 양수 여야합니다.");

        assertThat(CarRace.receiveCarNum(positiveNumCar)).isEqualTo(positiveNumCar);
    }

    @DisplayName("시도 회수는 1 이상이어야 합니다.")
    @Test
    public void receiveNumTryTest() {
        int negativeNumTry = -1;
        int positiveNumTry = 2;

        assertThatThrownBy(() -> CarRace.receiveNumTry(negativeNumTry))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("시도할 회수는 양수 여야합니다.");

        assertThat(CarRace.receiveNumTry(positiveNumTry)).isEqualTo(positiveNumTry);
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

    @DisplayName("자동차 대수로 양수를 받아야합니다. 상태는 무조건 한칸(-)씩 있어야합니다. ")
    @Test
    public void updateCurrentStateTest() {
        int negativeNumCar = -1;
        String[] emptyCars = {};
        assertThatThrownBy(() -> CarRace.updateCurrentState(emptyCars, negativeNumCar))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 대수는 양수 여야합니다.");

        int positiveNumCar = 3;
        String[] cars = {"-", "-", "-"};
        CarRace.updateCurrentState(cars, positiveNumCar);
    }

    @DisplayName("0 ~ 9 사이의 랜덤 값을 받고, 값을 보고 움직임 여부를 결정 및 움직입니다.")
    @Test
    public void checkAndMoveTest() {
        String[] cars = {"-", "-", "-"};
        int negativeVal = -1;
        assertThatThrownBy(() -> CarRace.checkAndMove(cars, 0, negativeVal))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("랜덤 값은 0에서 9사이의 값이어야합니다.");

        int positiveVal = 1;
        CarRace.checkAndMove(cars, 0, positiveVal);
    }
}
