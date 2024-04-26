import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @DisplayName("사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있다. ")
    @Test
    public void inputCountCarAndMove() {
        int carCount = 3;
        int moveCount = 5;

        RacingCar racingCar = new RacingCar(new RandomMove(), "car1,car2,car3");
        racingCar.setCarCount(carCount); // 테스트용 메서드 호출
        racingCar.setMoveCount(moveCount); // 테스트용 메서드 호출

        assertThat(racingCar.getCarCount()).isEqualTo(carCount);
        assertThat(racingCar.getMoveCount()).isEqualTo(moveCount);
    }

    @Test
    public void 자동차이름은_쉼표를_기준으로_구분한다() {
        RacingCar racingCar = new RacingCar(new RandomMove(), "car1,car2,car3");

        assertThat(racingCar.getCarCount()).isEqualTo(3);
    }

    @Test
    public void 자동차경주게임을_완료한후_누가_우승했는지를_알려준다_우승자가_한명이상일수있다() {
        RacingCar racingCar = new RacingCar(new RandomMove(), "car1,car2,car3");

        assertThat(racingCar.getWinners().size()).isGreaterThan(1);
    }
}
