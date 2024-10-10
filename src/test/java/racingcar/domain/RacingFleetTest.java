package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingFleetTest {
    @Test
    @DisplayName("차 이름으로 생성되면 입력한 수만큼 RacingCar들을 가집니다.")
    void initializedRacingCarsSizeTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        RacingFleet fleet = RacingFleet.valueOf(carNames);
        assertThat(fleet.getRacingCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("같은 이름셋으로 생성한 racingFleets는 equals가 true입니다.")
    void equalsTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        RacingFleet fleet1 = RacingFleet.valueOf(carNames);
        RacingFleet fleet2 = RacingFleet.valueOf(carNames);
        assertThat(fleet1).isEqualTo(fleet2);
    }

    @Test
    @DisplayName("같은 이름셋으로 생성한 racingFleets는 hashcode가 같습니다.")
    void hashCodeTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        RacingFleet fleet1 = RacingFleet.valueOf(carNames);
        RacingFleet fleet2 = RacingFleet.valueOf(carNames);
        assertThat(fleet1.hashCode()).isEqualTo(fleet2.hashCode());
    }

    @Test
    @DisplayName("승자 리스트는 racing차중에 하나의 이름을 가집니다.")
    public void findWinnersTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        RacingFleet fleet = RacingFleet.valueOf(carNames);
        List<RacingCar> winners = fleet.findWinners();
        assertThat(winners).allMatch(racingCar -> carNames.contains(racingCar.getName()));
    }
}
