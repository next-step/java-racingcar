package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    public void setUp() {
        racingCar = new RacingCar();
    }

    @DisplayName("전진하는 조건은 0에서 9 사이에서 4이상일 경우이다.")
    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8, 9 })
    public void shouldGoOneStep_whenNumberIsUpToFour(int conditionToGo) throws Exception {
        //given
        int oneStep = 1;
        boolean coin = CarNavigator.flipCoin(conditionToGo);
        //when
        racingCar.moveOrStop(coin);
        //then
        assertThat(racingCar.getDistance()).isEqualTo(oneStep);
    }

    @DisplayName("전진하지 않는 조건은 0에서 9 사이에서 4미만일 경우이다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3 })
    public void shouldStop_whenNumberIsUnderFour(int conditionToStop) throws Exception {
        //given
        int NoStep = 0;
        boolean coin = CarNavigator.flipCoin(conditionToStop);
        //when
        racingCar.moveOrStop(coin);
        //then
        assertThat(racingCar.getDistance()).isEqualTo(NoStep);
    }

    @DisplayName("입력받은 이름에 대해 차를 생성하고 이름을 부여할 수 있다.")
    @Test
    public void shouldNameAndCreateCar_whenInputName() throws Exception {
        //given
        String name = "name";
        //when
        RacingCar car = new RacingCar(name);
        //then
        assertThat(car.getName()).isEqualTo(name);
    }
}

