import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @DisplayName("사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있다. ")
    @Test
    public void inputCountCarAndMove() {
        int carCount = 3;
        int moveCount = 5;

        RacingCar racingCar = new RacingCar();
        racingCar.setCarCount(carCount); // 테스트용 메서드 호출
        racingCar.setMoveCount(moveCount); // 테스트용 메서드 호출

        assertThat(racingCar.getCarCount()).isEqualTo(carCount);
        assertThat(racingCar.getMoveCount()).isEqualTo(moveCount);
    }
}
