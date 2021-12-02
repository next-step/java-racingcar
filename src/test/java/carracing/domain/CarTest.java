package carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("자동차 테스트")
class CarTest {

    private static final int INITIATION_POSITION_NUMBER = 0;
    private static final int FIRST_MOVING_POSITION_NUMBER = INITIATION_POSITION_NUMBER + 1;
    private static final String TEST_CAR_NAME = "pobi";

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new CarName(TEST_CAR_NAME));
    }

    @DisplayName("유효한 자동차 생성 확인")
    @Test
    void createCarTest() {
        // then
        assertThat(car).isNotNull();
        assertThat(car.getPosition()).isEqualTo(new CarPosition(INITIATION_POSITION_NUMBER));
        assertThat(car.getName()).isEqualTo(new CarName(TEST_CAR_NAME));
    }

    @DisplayName("자동차가 움직일 수 있는 경우, 자동자의 위치가 변경되는지 확인")
    @Test
    void moveCarTest() {
        // when
        Car movedCar = car.move(() -> true);
        // then
        assertThat(movedCar.getPosition()).isEqualTo(new CarPosition(FIRST_MOVING_POSITION_NUMBER));
    }

    @DisplayName("자동차가 움직일 수 없는 경우, 자동자의 위치가 변경되는지 확인")
    @Test
    void checkUnmovableCarTest() {
        // when
        Car unmovedCar = car.move(() -> false);
        // then
        assertThat(unmovedCar.getPosition()).isEqualTo(new CarPosition(INITIATION_POSITION_NUMBER));
    }

    @DisplayName("자동차가 승리한 자동차인지 확인")
    @Test
    void isWonTest() {
        // given
        int numberOfTrial = 3;
        // when
        for (int i = 0; i < numberOfTrial; i++) {
            car = car.move(() -> true);
        }
        // then
        assertTrue(car.isWon(numberOfTrial));
    }
}
