import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    public void 자동차이름은_쉼표를_기준으로_구분한다() {
        RacingCar racingCar = new RacingCar("car1,car2,car3");

        assertThat(racingCar.getCarCount()).isEqualTo(3);
    }

    @Test
    public void 자동차경주게임을_완료한후_누가_우승했는지를_알려준다_우승자가_한명이상일수있다() {
        RacingCar racingCar = new RacingCar("car1,car2,car3");

        assertThat(racingCar.getWinners().size()).isGreaterThan(1);
    }
}
