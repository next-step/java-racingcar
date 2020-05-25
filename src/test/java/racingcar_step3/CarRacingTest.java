package racingcar_step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("초간단 자동차 경주 테스트")
public class CarRacingTest {

    private int racingCarCount;
    private int racingCount;
    private CarRacingGame racingGame = new CarRacingGame();
    private List<Integer> result = new ArrayList<>();

    @BeforeEach
    void init(){
        this.racingCarCount = 5;
        this.racingCount = 3;
    }

    @Test
    @DisplayName("Test1 입력값변수 2개중 1개 이상 값이 0 이하인 경우")
    void inputErrorTest() {
        int racingCarCount = 0;
        InputView inputView = new InputView();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.validateInput(racingCarCount, racingCount);
        });
    }

    @Test
    @DisplayName("Test2 자동차 생성 테스트")
    void inputCarsTest() {
        this.result = racingGame.createCars(this.racingCarCount);
        assertThat(result).hasSize(5);
    }

    @Test
    @DisplayName("Test3 자동자 이동 테스트")
    void moveTest() {
        int forward = Car.setForward(7);
        assertThat(forward).isEqualTo(1);

        int totalDistance = Car.setForward(7);
        assertThat(totalDistance).isEqualTo(1);
    }

    @Test
    @DisplayName("Test4 자동자 정지 테스트")
    void moveStopTest() {
        int forward = Car.setForward(3);
        assertThat(forward).isEqualTo(0);

        int totalDistance = Car.setForward(3);
        assertThat(totalDistance).isEqualTo(0);
    }
}
