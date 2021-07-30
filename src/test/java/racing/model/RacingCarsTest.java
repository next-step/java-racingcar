package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("경주용 자동차 컬렉션 테스트")
public class RacingCarsTest {

    @DisplayName("자동차 이름은 주입받은 자동차 이름으로 만들어져야 한다.")
    @Test
    public void racingCarNamesTest() {
        // given
        String[] racingCarNames = new String[]{ "pobi", "crong", "honux" };

        // when
        RacingCars racingCars = new RacingCars(racingCarNames);

        // then
        assertThat(racingCars.getNames())
                .containsExactly(racingCarNames);
    }

    @DisplayName("자동차 대수가 1대 미만이면, IllegalArgumentException이 발생한다.")
    @Test
    public void minRacingCarCountExceptionTest() {
        // given
        String[] racingCarNames = new String[0];

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCars(racingCarNames))
                .withMessage("자동차는 1대 이상이어야 합니다.");
    }

    @DisplayName("이동 조건이 true면 자동차는 한 칸 전진한다.")
    @Test
    public void moveTest() {
        // given
        RacingCars racingCars = new RacingCars(new String[]{ "pobi", "crong", "honux" });

        // when
        racingCars.moveForwardOneStepOrStop(() -> true);

        // then
        assertThat(racingCars.getPositions())
                .containsExactly(1, 1, 1);
    }

    @DisplayName("이동 조건이 false면 자동차는 멈춘다.")
    @Test
    public void stopTest() {
        // given
        RacingCars racingCars = new RacingCars(new String[]{ "pobi", "crong", "honux" });

        // when
        racingCars.moveForwardOneStepOrStop(() -> false);

        // then
        assertThat(racingCars.getPositions())
                .containsExactly(0, 0, 0);
    }

    @DisplayName("가장 많이 앞으로 이동한 자동차가 우승자이다.")
    @Test
    public void winnersTest() {
        // given
        RacingCars racingCars = new RacingCars(new String[]{"pobi", "crong", "aiden"});
        RacingCar pobiCar = racingCars.getRacingCars().get(0);
        RacingCar crongCar = racingCars.getRacingCars().get(1);
        RacingCar aidenCar = racingCars.getRacingCars().get(2);

        // when
        pobiCar.moveForwardOneStepOrStop(() -> false);
        crongCar.moveForwardOneStepOrStop(() -> true);
        aidenCar.moveForwardOneStepOrStop(() -> true);

        pobiCar.moveForwardOneStepOrStop(() -> false);
        crongCar.moveForwardOneStepOrStop(() -> true);
        aidenCar.moveForwardOneStepOrStop(() -> true);

        // then
        assertThat(racingCars.findWinners().toArray())
                .containsExactlyInAnyOrder(crongCar, aidenCar);
    }
}
