package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        List<String> carName = Arrays.asList("lee","kim","tt");
        racingCars = RacingCars.racingGameReady(carName);
    }

    @Test
    @DisplayName("자동차 여러대를 입력했을 경우 잘 입력 되었는지 확인")
    void setArrayCarName() {

        assertThat(racingCars.getCars().contains(new RacingCar("lee"))).isTrue();
        assertThat(racingCars.getCars().contains(new RacingCar("kim"))).isTrue();
    }

    @Test
    @DisplayName(("우승자를 찾아보기"))
    void getVictoryNameTest() {
        List<String> carNames = Arrays.asList("lee", "kim", "joo");
        String winner = "lee,kim";

        RacingCars cars = RacingCars.racingGameReady(carNames);

        cars.getCars().get(0).decisionMove(true);
        cars.getCars().get(0).decisionMove(true);
        cars.getCars().get(1).decisionMove(true);
        cars.getCars().get(1).decisionMove(true);
        cars.getCars().get(2).decisionMove(true);

        String result = cars.getVictoryUsers();

        assertThat(result).isEqualTo(winner);
    }

}
