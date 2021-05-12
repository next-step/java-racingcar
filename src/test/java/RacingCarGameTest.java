import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCarGameTest {
    @DisplayName(value = "게임을 시도할 횟수는 0 이상이어야 한다.")
    @Test
    void when_RoundNumber_is_smaller_than_0_throw_IllegalArgumentException() {
        RacingCarGameController racingCarController = new RacingCarGameController();
        int roundNumber = -1;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingCarController.checkRoundNumber(roundNumber);
        });
    }

    @DisplayName(value = "자동차 이름은 쉼표(,)를 기준으로 구분한다.")
    @Test
    void should_split_With_comma() {
        RacingCarGameController controller = new RacingCarGameController();
        String carNamesString = "pobi,woni,jun";
        String[] carNames = {"pobi", "woni", "jun"};
        assertThat(controller.splitBySeparator(carNamesString)).isEqualTo(carNames);
    }

    @DisplayName(value = "자동차 이름이 5자를 초과하면 IllegalArgumentException을 발생시킨다.")
    @Test
    void should_have_Less_than_5_letters() {
        RacingCar racingCar = new RacingCar("pobipobi");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingCar.checkCarNameLength();
        });
    }

    @DisplayName(value = "자동차들의 이름을 입력하면 각각의 자동차 객체를 만든다.")
    @Test
    void make_RacingCars() {
        RacingCarGameController racingCarController = new RacingCarGameController();
        String[] carNames = {"pobi", "woni", "jun"};
        List<RacingCar> racingCars = racingCarController.makeRacingCarsWithCarNames(carNames);

        assertThat(racingCars.get(0).getName()).isEqualTo("pobi");
    }

    @DisplayName(value = "자동차의 이름을 가져온다.")
    @Test
    void take_carName() {
        RacingCar racingCar = new RacingCar("pobi");
        assertThat(racingCar.getName()).isEqualTo("pobi");
    }

    @DisplayName(value = "자동차의 step을 가져온다.")
    @Test
    void take_carStep() {
        RacingCar racingCar = new RacingCar("pobi");
        assertThat(racingCar.getStep()).isEqualTo(0);
    }

    @DisplayName(value = "무작위값이 4 이상일 경우 자동차는 전진한다.")
    @Test
    void should_move_When_randomNumber_is_equal_or_greater_than_4() {
        RacingCar racingCar = new RacingCar("pobi");
        racingCar.move(4);
        assertThat(racingCar.getStep()).isEqualTo(1);
    }

    @DisplayName(value = "무작위값이 4 미만일 경우 자동차는 전진하지 않는다.")
    @Test
    void should_not_move_When_randomNumber_is_less_than_4() {
        RacingCar racingCar = new RacingCar("pobi,woni,jun");
        racingCar.move(3);
        assertThat(racingCar.getStep()).isEqualTo(0);
    }

    @DisplayName(value = "step에 맞춰 '-'를 출력한다.")
    @Test
    void should_be_same_As_the_number_of_step() {
        RacingCarGameOutputView racingCarGameOutputView = new RacingCarGameOutputView();
        assertThat(racingCarGameOutputView.showStep(5)).isEqualTo("-----");
    }

    @DisplayName(value = "최고점수를 구한다.")
    @Test
    void get_maxScore() {
        RacingCarGameController racingCarController = new RacingCarGameController();

        RacingCar racingCar = new RacingCar("pobi");
        racingCar.move(5);

        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(racingCar);

        assertThat(racingCarController.getMaxScore(racingCars)).isEqualTo(1);
    }

    @DisplayName(value = "우승자를 구한다.")
    @Test
    void get_winners() {
        RacingCarGameController racingCarController = new RacingCarGameController();

        RacingCar racingCar = new RacingCar("pobi");
        racingCar.move(5);

        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(racingCar);

        assertThat(racingCarController.getWinners(racingCars, 1)).isEqualTo(" pobi");

    }
}
