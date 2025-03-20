package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.entity.Car;
import racing.entity.RacingCars;
import racing.rule.RandomMoveRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {RandomMoveRule.MIN_MOVE_VALUE, RandomMoveRule.MIN_MOVE_VALUE + 2})
    @DisplayName("value가 MIN_MOVE_VALUE 이상이면 전진 가능하다.")
    public void car_moves_whenValueIs_MinMoveValueOrMore(int input) {
        RandomMoveRule randomMoveRule = new RandomMoveRule();

        boolean actual = randomMoveRule.isMovable(input);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {RandomMoveRule.MIN_MOVE_VALUE - 1, RandomMoveRule.MIN_MOVE_VALUE - 2})
    @DisplayName("value가 MIN_MOVE_VALUE 미만이면 움직이지 않는다.")
    public void car_stays_whenValueIs_LessThanMinMoveValue(int input) {
        RandomMoveRule randomMoveRule = new RandomMoveRule();

        boolean actual = randomMoveRule.isMovable(input);
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("가장 멀리간 자동차로 우승자를 선정한다. (단독 우승) ")
    public void select_winner_basedOn_MaxPosition() {
        // given
        Car ford = new Car("ford");
        Car kia = new Car("kia");
        Car tesla = new Car("tesla");
        RacingCars racingCars = new RacingCars(List.of(ford, kia, tesla));

        // when
        for (int i = 0; i < 3; i++) {
            ford.move();
        }

        // then
        List<String> actual = racingCars.getLeadingCarNameList();
        List<String> expected = List.of("ford");
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    @DisplayName("가장 멀리간 자동차로 우승자를 선정한다. (동반 우승) ")
    public void select_joint_winners_basedOn_MaxPosition() {
        // given
        Car ford = new Car("ford");
        Car kia = new Car("kia");
        Car tesla = new Car("tesla");
        RacingCars racingCars = new RacingCars(List.of(ford, kia, tesla));

        // when
        for (int i = 0; i < 3; i++) {
            ford.move();
            tesla.move();
        }

        // then
        List<String> actual = racingCars.getLeadingCarNameList();
        List<String> expected = List.of("ford", "tesla");
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}