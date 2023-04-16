import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.Race;
import domain.RacingCar;
import domain.CarNavigator;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    public void setUp() {
        racingCar = new RacingCar();
    }


    @DisplayName("전진하는 조건은 0에서 9 사이에서 4이상일 경우이다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
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
    @ValueSource(ints = {0, 1, 2, 3})
    public void shouldStop_whenNumberIsUnderFour(int conditionToStop) throws Exception {
        //given
        int NoStep = 0;
        boolean coin = CarNavigator.flipCoin(conditionToStop);
        //when
        racingCar.moveOrStop(coin);
        //then
        assertThat(racingCar.getDistance()).isEqualTo(NoStep);
    }

    @DisplayName("randomNumber를 생성해 4 이상이면 참을 반환한다")
    @Test
    public void shouldReturnTrue_whenRandomNumberIsAboveStandard() {
        //given
        int randomNum = CarNavigator.getRandomNumber();
        int standard = 4;

        //when
        boolean coin = CarNavigator.flipCoin(randomNum);

        //then
        if (randomNum >= standard) {
            assertThat(coin).isTrue();
        }
    }

    @DisplayName("randomNumber를 생성해 4 미만이면 거짓을 반환한다")
    @Test
    public void shouldReturnFalse_whenRandomNumberIsBelowStandard() {
        //given
        int randomNum = CarNavigator.getRandomNumber();
        int standard = 4;

        //when
        boolean coin = CarNavigator.flipCoin(randomNum);

        //then
        if (randomNum < standard) {
            assertThat(coin).isFalse();
        }
    }

    @DisplayName("입력받은 차 대수만큼 차를 생성한다")
    @Test
    public void shouldCreateCars_whenInputNumberOfCar() throws Exception {
        //given
        int inputNum = 3;
        //when
        List<RacingCar> racingCarList = Race.createCar(inputNum);
        //then
        assertThat(racingCarList.size()).isEqualTo(inputNum);
    }

    @DisplayName("입력받은 경기 횟수만큼 경기를 진행한다")
    @Test
    public void shouldPlayGameForSpecifiedNumberOfRounds_whenNumberOfRoundsIsSpecified() throws Exception {
        //given

        //when

        //then
    }


}
