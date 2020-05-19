package racingcar_step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("초간단 자동차 경주 테스트")
public class CarRacingTest {

    private int racingCarCount;
    private int racingCount;
    private Car car;

    @BeforeEach
    void init(){
        this.racingCarCount = 5;
        this.racingCount = 3;
        this.car = new Car(racingCarCount, racingCount);
    }

    @Test
    @DisplayName("Test1 입력값변수 2개중 1개 이상 값이 0 이하인 경우")
    void inputErrorTest() {
        int racingCarCount = 0;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            car = new Car(racingCarCount, this.racingCount);
        });
    }

    @Test
    @DisplayName("Test2 자동차 위치 테스트")
    void carPositionTest() {
        CarRacingGame carRacingGame = new CarRacingGame(car);
        List<Integer> carPositions = carRacingGame.getRacingPositions();
        assertThat(carPositions).hasSize(5);
    }

    @Test
    @DisplayName("Test3 자동자 이동 테스트")
    void moveTest() {
        int forward = car.setForward(7);
        assertThat(forward).isEqualTo(1);

        CarRacingGame carRacingGame = new CarRacingGame(car);

        carRacingGame.runRacing();
        List<Integer> carPositions = carRacingGame.getRacingPositions();
        assertThat(carPositions).hasSize(5);
    }

    @Test
    @DisplayName("Test4 자동자 정지 테스트")
    void moveStopTest() {
        int forward = car.setForward(3);
        assertThat(forward).isEqualTo(0);

        CarRacingGame carRacingGame = new CarRacingGame(car);

        carRacingGame.runRacing();
        List<Integer> carPositions = carRacingGame.getRacingPositions();
        assertThat(carPositions).hasSize(5);
    }
}
