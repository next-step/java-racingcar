import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcargame.controller.RacingCarGameController;
import racingcargame.model.RacingCar;
import racingcargame.view.RacingCarGameOutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RacingCarGameTest {
    private RacingCarGameController controller;
    private RacingCarGameOutputView outputView;
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        controller = new RacingCarGameController();
        outputView = new RacingCarGameOutputView();
        racingCar = new RacingCar("pobi");
    }

    static Stream<String> blankStrings() {
        return Stream.of("", null);
    }

    @DisplayName(value = "자동차 이름이 빈 문자열이거나 null 이라면 IllegalArgumentException 을 발생시킨다.")
    @ParameterizedTest
    @MethodSource("blankStrings")
    void should_have_name(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCar racingCar = new RacingCar(input);
        });
    }

    @DisplayName(value = "자동차 이름은 5자 이내이다.")
    @ParameterizedTest
    @ValueSource(strings = {"jun", "pobi", "alice"})
    void should_have_less_than_5_letters(String input) {
        try {
            RacingCar racingCar = new RacingCar(input);
        } catch (Exception e) {
            fail("예외가 발생하지 않았다.");
        }
    }

    @DisplayName(value = "자동차 이름이 5자를 초과하면 IllegalArgumentException 을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"junjun", "rainbow", "pobipobi"})
    void should_not_have_much_than_5_letters(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCar racingCar = new RacingCar(input);
        });
    }

    @DisplayName(value = "자동차의 이름을 가져온다.")
    @Test
    void take_carName() {
        assertThat(racingCar.getName()).isEqualTo("pobi");
    }

    @DisplayName(value = "자동차의 step을 가져온다.")
    @Test
    void take_carStep() {
        assertThat(racingCar.getStep()).isEqualTo(0);
    }

    @DisplayName(value = "무작위값이 4 이상일 경우 자동차는 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void should_move_When_randomNumber_is_equal_or_greater_than_4(int input) {
        racingCar.move(input);
        assertThat(racingCar.getStep()).isEqualTo(1);
    }

    @DisplayName(value = "무작위값이 4 미만일 경우 자동차는 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void should_not_move_When_randomNumber_is_less_than_4(int input) {
        racingCar.move(input);
        assertThat(racingCar.getStep()).isEqualTo(0);
    }

    @DisplayName(value = "최고점수를 구한다.")
    @Test
    void get_maxScore() {
        racingCar.move(5);

        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(racingCar);

        assertThat(controller.findMaxScore(racingCars)).isEqualTo(1);
    }

    @DisplayName(value = "우승자를 구한다.")
    @Test
    void get_winners() {
        racingCar.move(5);

        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(racingCar);

        assertThat(controller.findWinners(racingCars, 1)).isEqualTo(" pobi");

    }
}
