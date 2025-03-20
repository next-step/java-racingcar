package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.RacingCars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {
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